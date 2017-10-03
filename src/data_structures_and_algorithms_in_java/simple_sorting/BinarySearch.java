package data_structures_and_algorithms_in_java.simple_sorting;

class BinarySearch {

    private int[] data;
    private int size;

    private BinarySearch() {
    }

    private boolean binarySearch(int key) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (data[middle] == key)
                return true;

            if (data[middle] < key)
                low = middle + 1;

            if (data[middle] > key)
                high = middle - 1;
        }
        return false;
    }

}
