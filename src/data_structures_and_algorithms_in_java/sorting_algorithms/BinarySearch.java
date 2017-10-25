package data_structures_and_algorithms_in_java.sorting_algorithms;

class BinarySearch {

    private int[] data;
    private int size;

    private BinarySearch() {
    }

    private boolean binarySearch(int key) { // O(log N)
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

    private int recursiveBinarySearch(int searchKey, int lowerBound, int upperBound) {
        int curIndex;

        curIndex = (lowerBound + upperBound) / 2;
        if (data[curIndex] == searchKey)
            return curIndex;
        else if (lowerBound > upperBound)
            return size;
        else {
            if (data[curIndex] < searchKey)
                return recursiveBinarySearch(searchKey, curIndex + 1, upperBound);
            else
                return recursiveBinarySearch(searchKey, lowerBound, curIndex - 1);
        }
    }

}
