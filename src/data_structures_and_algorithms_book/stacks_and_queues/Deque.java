package data_structures_and_algorithms_book.stacks_and_queues;

public class Deque { // TODO: Refactoring

    private long [] dequeArray;
    private int front;
    private int rear; // top
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

    }

    public void insertRight(long elem) { // like Queue
        if (rear == maxSize -1)
            rear = -1;

        if (!isFull())
            dequeArray[++rear] = elem;

        items++;
    }

    public void removeLeft() { // like Queue

        long temp = dequeArray[front++];

        if (front == maxSize)
            front = 0;
        items--;
    }

    public void removeRight() {

    }

    public boolean isEmpty() {


    }

    public boolean isFull() {
        return items == maxSize - 1 ? true : false;
    }
}

