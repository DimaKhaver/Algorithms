package data_structures_and_algorithms_book.simple_sorting;

/**
 * Created by dmitriy on 08.07.17.
 */
public class ArrayInsertionSort {

    private long[] a;
    private int elems;

    public ArrayInsertionSort(int max) {
        a = new long[max];
        elems = 0;
    }

    public void insert(long value) {
        a[elems] = value;
        elems++;
    }

    public void display() {
        for (int j = 0; j < elems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void insertionSort() { // O(N^2)
        int in, out;

        for (out = 1; out < elems; out++) {

            long temp = a[out];
            in = out;

            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }

            a[in] = temp;
        }
    }
}
