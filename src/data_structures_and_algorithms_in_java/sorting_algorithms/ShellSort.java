package data_structures_and_algorithms_in_java.sorting_algorithms;

public class ShellSort {

    private long[] array;
    private int elements;

    ShellSort(int max) {
        array = new long[max];
        elements = 0;
    }

    public void insert(long value) {
        array[elements] = value;
        elements++;
    }

    public void display() {
        System.out.print("A=");
        for(int j=0; j < elements; j++)
            System.out.print(array[j] + " ");
        System.out.println("");
    }

    // FROM O(N 3/2) down to O(N 7/6)
    public void shellSort1() {
        int inner, outer;
        long temp;

        int h = 1; // find initial value of h
        while (h <= elements/3) {
            h = h*3 + 1; // (1, 4, 13, 40, 121, ...)
        }

        while (h > 0) {     // decreasing h, until h = 1
            for (outer = h; outer < elements; outer++) { // h-sort the file
                temp = array[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h-1) / 3; // decrease h
        }
    }

    // 2nd implementation
    void shellSort2() {
        int n = array.length;
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                long temp = array[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                array[j] = temp;
            }
        }
    }
}
