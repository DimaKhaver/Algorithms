package datastructuresandalgorithmsinjava.stacksandqueues;

public class Deque { // O(1)
    private long [] dequeArray;
    private int front;
    private int rear; // top of the Deque
    private int items;
    private int maxSize;

    public Deque(int elem) {
        maxSize = elem;
        dequeArray = new long[maxSize];
        rear = -1;
        front = 0;
        items = 0;
    }

    public void insertLeft(long elem) {
        if (items < maxSize) {
            for (int i = rear + 1; i > 0; --i) {
                dequeArray[i] = dequeArray[i-1];
            }
            dequeArray[front] = elem;
        }
    }

    public void insertRight(long elem) {
        if (rear == maxSize -1)
            rear = -1;
        else {
            if (!isFull())
                dequeArray[++rear] = elem;

            items++;
        }
    }

    public void removeLeft() {
        long temp = dequeArray[front++];
        if (front == maxSize)
            front = 0;
        items--;
    }

    public void removeRight() {
        dequeArray[rear--] = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize - 1;
    }
}

