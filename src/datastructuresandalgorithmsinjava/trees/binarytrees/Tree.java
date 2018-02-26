package datastructuresandalgorithmsinjava.trees.binarytrees;

import java.util.Stack;

// Binary trees O(log N)
class Node {
    public int iData; // data item (key)
    public double dData; // data item
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print("{");
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}

public class Tree {
    private Node root;

    public Tree() {
        root = null; // 0 nodes
    }

    public Node find(int key) {
        Node current = root; // start at root

        while (current.iData != key) {
            if (key < current.iData) // go left
                current = current.leftChild;
            else                     // go right
                current = current.rightChild;
            if (current == null)
                return null; // found nothing
        }
        return current; // found it
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (id < current.iData) { // go left
                    current = current.leftChild;
                    if (current == null) { // if end of the line - insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {// if end of the line
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) { // go left
                isLeftChild = true;
                current = current.leftChild;
            } else {                   // go right
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // end of the line
                return false; // didn't find it
        }
        // found node to delete, if no children - simply delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) // if root - tree is empty
                root = null;
            else if (isLeftChild)
                parent.leftChild = null; // disconnect from parent
            else
                parent.rightChild = null;
        }
        // if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }
        // if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        else { // two children, so replace with inorder successor
            Node successor = getSuccessor(current); // get successor of node to delete (current)
            // connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        }
        return true;
    }
    // return node with next-highest value after delNode
    // goes to right child, then right child's left descendents
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child

        while (current != null) { // until no more, left children
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        if (successor != delNode.rightChild) { // if successor not right child, make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch(traverseType) {
            case 1: System.out.println("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.println("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.println("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int blanks = 32;
        boolean isRowEmpty = false;
        System.out.println("...");

        while (!isRowEmpty) {
            final Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < blanks; j++) {
                System.out.println(' ');
            }

            while (!globalStack.isEmpty()) {
                final Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.println("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < blanks*2-2; j++)
                    System.out.println(" ");
            } // end while globalStack not empty
            blanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
    }
}
