package datastructuresandalgorithmsinjava.sortingalgorithms;

/**
 * Created by dmitriy on 23.06.17.
 */
public class BubbleSort {

    private long[] a;
    private int elems;

    public BubbleSort(int max) {
        a = new long[max];
        elems = 0;
    }

    public void insert(long value) {
        a[elems] = value;
        elems++;
    }

    public void display() {
        for (int j = 0; j < elems; ++j)
            System.out.println(a[j] + " ");
        System.out.println("");
    }

    // Lower values accumulate on the right
    public void bubbleSort() { // O(N^2)
        int out, in;

        for (out = elems - 1; out > 1; out--) // <--
            for (in = 0; in < out; in++) // -->
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }


}
