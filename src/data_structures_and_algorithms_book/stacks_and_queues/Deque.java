package data_structures_and_algorithms_book.stacks_and_queues;

public class Deque {

    private long [] dequeArray;
    private int front;
    private int rear;
    private int items;
    private int maxSize;

    public Deque(int elem) {
        maxSize = elem;
        dequeArray = new long[maxSize];

        rear = -1;
        front = 0;
        items = 0;
    }

    public void insertLeft() { // like Stack(LIFO)

    }

    public void insertRight() { // like Queue(FIFO)

    }

    public void removeLeft() { // like Stack(LIFO)

    }

    public void removeRight() { // like Queue(FIFO)

    }

    public boolean isEmpty() {

    }

    public boolean isFull() {
        return items == maxSize ? true : false;
    }
}

