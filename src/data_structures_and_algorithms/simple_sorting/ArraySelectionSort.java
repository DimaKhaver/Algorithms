package data_structures_and_algorithms.simple_sorting;

/**
 * Created by dmitriy on 08.07.17.
 */
public class ArraySelectionSort {

    private long [] a;
    private int elems;


    public ArraySelectionSort(int max) {
        a = new long[max];
        elems = 0;
    }

    public void insert(long value) {
        a[elems] = value;
        elems++;
    }

    public void display() {
        for (int j = 0; j < elems; ++j)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void selectionSort() {

        int out, in, min;

        for (out = 0; out < elems - 1; out++) {
            min = out;

            for (in = out + 1; in < elems; in++)
                if (a[in] < a[min])
                    min = in;

            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];

        a[one] = a[two];
        a[two] = temp;
    }
}
