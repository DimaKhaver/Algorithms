package data_structures_and_algorithms_in_java.sorting_algorithms;

public class Partition {
    private long[] array;
    private int elems;

    public Partition(int max) {
        array = new long[max];
        elems = 0;
    }

    public void insert(long value) {
        array[elems] = value;
        elems++;
    }
    // O(N)
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1; // right of 1st element
        int rightPtr = right + 1; // left of pivot

        while (true) {
            while (leftPtr < right && array[++leftPtr] < pivot); // find bigger item
            while (rightPtr > left && array[--rightPtr] > pivot); // find smaller item

            if (leftPtr >= rightPtr) // if pointers cross - partition done
                break;
            else
                swap(leftPtr, rightPtr); // not crossed - swap elements
        }
        return leftPtr;
    }

    private void swap(int dex1, int dex2) {
        long temp;
        temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }
}
