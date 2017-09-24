package data_structures_and_algorithms_book.stacks_and_queues;

public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int items;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(long j) {
        if (rear == maxSize -1)
            rear = -1;
        queArray[++rear] = j;
        items++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        items--;

        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

}
