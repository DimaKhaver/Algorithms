package data_structures_and_algorithms_in_java.stacks_and_queues;

public class PriorityQueue { // Simple array-based priority queue

    private int maxSize;
    private long [] queArray;
    private int items;

    public PriorityQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        items = 0;
    }

    public void insert(long item) {
        int j = 0;

        if (items == 0)
            queArray[items++] = item;
        else {
            for (j = items - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    if (!isFull())
                        queArray[j + 1] = queArray[j];
                }
                else
                    break;
            }
        }

        queArray[j+1] = item;
        items++;
    }

    public long remove() {
        return queArray[--items];
    }

    public long peekMin() {
        return queArray[items - 1];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

}
