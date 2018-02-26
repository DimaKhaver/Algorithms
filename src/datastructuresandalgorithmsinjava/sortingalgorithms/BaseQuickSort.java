package datastructuresandalgorithmsinjava.sortingalgorithms;

public class BaseQuickSort { // O(n*log n)
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        if (values == null || values.length == 0)
            return;

        numbers = values;
        number = values.length;
        quickSort(0, number - 1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = numbers[low + (high - low) / 2]; // get the pivot element from the middle of the list

        while (i <= j) { // Divide into two lists
            // If the current value from the left list < pivot ->
            // get the next element from the left list
            while (numbers[i] < pivot) {
                ++i;
            }
            // If the current value from the right list > pivot ->
            // get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we found a value in the left list which > pivot
            // and if we found a value in the right list < the pivot element
            // then we exchange the values.
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }

            // Recursion
            if (low < j)
                quickSort(low, j);
            if (i < high)
                quickSort(i, high);
        }
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

// demonstrates quick sort with median-of-three partitioning
class QuickSort {
    private long[] array;
    private int elems;

    public QuickSort(int max) {
        array = new long[max];
        elems = 0;
    }

    public void insert(long value) {
        array[elems] = value;
        elems++;
    }

    public void display() {
    }

    public void quickSort() {
        recQuickSort(0, elems - 1);
    }

    private void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)  // manual sort if small
            manualSort(left, right);
        else {  // quickSort if large
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public void recQuickSort2(int left, int right) { // this example uses insertion sort for cleanup
        int size = right - left + 1;
        if (size <= 10)  // insertion sort if small
            manualSort(left, right);
        else {  // quickSort if large
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private void insertionSort(int left, int right) {
        int in, out;

        for (out = left + 1; out <= right; out++) {
            long temp = array[out];
            in = out;

            while (in > left && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }

    private long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center])
            swap(left, center);
        if (array[left] > array[right])
            swap(left, right);
        if( array[center] > array[right] )
            swap(center, right);

        swap(center, right-1); // put pivot on right
        return array[right-1]; // return median value
    }

    private void swap(int dex1, int dex2) {
        long temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left; // right of first elem
        int rightPtr = right - 1; // left of pivot

        while (true) {
            while (array[++leftPtr] < pivot); // find bigger
            while (array[--rightPtr] > pivot); // find smaller

            if (leftPtr >= rightPtr) // if pointers cross -> partition done
                break;
            else
                swap(leftPtr, rightPtr); // not crossed -> swap elements
        }
        swap(leftPtr, right - 1); // restore pivot
        return leftPtr; // return pivot location
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return; // no sort necessary
        if (size == 2) { // 2-sort left and right
            if (array[left] > array[right])
                swap(left, right);
            return;
        }
        else { // size == 3; 3-sort left, center and right
            if (array[left] > array[right - 1])
                swap(left, right - 1); // left, center
            if (array[left] > array[right])
                swap(left, right); // left, right
            if( array[right-1] > array[right] )
                swap(right-1, right); // center, right
        }
    }
}

