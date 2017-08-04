package data_structures_and_algorithms_book.simple_sorting;

public class OddEvenSort {

    private long[] a;
    private int elems;

    public OddEvenSort(int max) {
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

    public void oddEvenSort(){

        boolean isSorted = false;

        while (!isSorted) {

            isSorted = true;

            for (int i = 0; i <= elems - 2; i += 2) { // odd indexed elements
                if (a[i] > a[i+1])
                    swap(a[i], a[i+1]);
                isSorted = false;
            }

            for (int i = 1; i <= elems - 2; i += 2) { // even indexed elements
                if (a[i] > a[i+1])
                    swap(a[i], a[i+1]);
                isSorted = false;
            }
        }
    }

    public void swap(long a, long b) {
        long c = a;
        a = b;
        b = c;
    }
}
