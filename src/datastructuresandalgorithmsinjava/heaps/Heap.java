package datastructuresandalgorithmsinjava.heaps;

/*
A heap is a binary tree with these characteristics:
• It’s complete - it’s completely filled in, reading from left to right
across each row, although the last row need not be full.
• It’s (usually) implemented as an array.
• Each node in a heap satisfies the heap condition, which states that every node’s
key is larger than (or equal to) the keys of its children.

A heap is a special kind of binary tree, the number of levels L in a binary tree
equals log2(N+1), where N is the number of nodes. The trickleUp() and trickleDown()
routines cycle through their loops L-1 times, so the first takes time proportional to log2N,
and the second somewhat more because of the extra comparison.
The heap operations all operate in O(logN) time.
*/

class Node {
    private int data;

    public Node(int key) {
        data = key;
    }

    public int getKey() {
        return data;
    }

    public void setKey(int id) {
        data = id;
    }
}

public class Heap {
    private Node[] heapArray;
    private int maxSize; // size of array
    private int currentSize; // number of nodes in array

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize)
            return false;
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
            int leftChild = 2*index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if (top.getKey() >= heapArray[largerChild].getKey())
                break;

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize)
            return false;
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if(oldValue < newValue)
            trickleUp(index);
        else
            trickleDown(index);
        return true;
    }
  // allows direct insertion into the heap’s array
    public void insertAt(int index, Node newNode) {
        heapArray[index] = newNode;
    }

    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int m=0; m<currentSize; m++) {
            if (heapArray[m] != null)
                System.out.print( heapArray[m].getKey() + " ");
            else
                System.out.println("-- ");
        }
        int blanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "................";
        System.out.println(dots+dots);

        while(currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < blanks; k++)
                    System.out.print(' ');
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize)
                break;
            if (++column == itemsPerRow) {
                blanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < blanks*2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
    }

}
