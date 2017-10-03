package data_structures_and_algorithms_in_java.simple_sorting;

/**
 * Created by dmitriy on 08.07.17.
 */
public class ArrayInsertionSort {

    private long[] a;
    private int elems;
    private int lastUnrepeatedIndex = 0;
    private int repeatedDigitsCount = 0;

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

    public void noDups() { // Deleting all duplicates
        // (no item is moved more than once - no matter how many duplicates there are)
        for (int i = 0; i < elems; ++i) {
            if (!isRepeated(i)) {
                if (lastUnrepeatedIndex < elems - 1) {
                    if (i > lastUnrepeatedIndex) {
                        a[lastUnrepeatedIndex + 1] = a[i];
                        lastUnrepeatedIndex += 1;
                    }
                }
            }
        }

        elems -= repeatedDigitsCount;
    }

    private boolean isRepeated(int index) {
        boolean isRepeated = false;

        for (int j = 0; j < index; ++j) {
            if (a[j] == a[index]) {
                isRepeated = true;
                repeatedDigitsCount++;

                break;
            }
        }

        return isRepeated;
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
