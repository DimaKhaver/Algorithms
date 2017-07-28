
package data_structures_and_algorithms_book;

import data_structures_and_algorithms_book.simple_sorting.ArrayInsertionSort;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        ArrayInsertionSort arrayInsertionSort = new ArrayInsertionSort(20);

        arrayInsertionSort.insert(2L);
        arrayInsertionSort.insert(2L);
        arrayInsertionSort.insert(2L);
        arrayInsertionSort.insert(3L);
        arrayInsertionSort.insert(3L);
        arrayInsertionSort.insert(3L);
        arrayInsertionSort.insert(3L);
        arrayInsertionSort.insert(4L);
        arrayInsertionSort.insert(4L);
        arrayInsertionSort.insert(4L);
        arrayInsertionSort.insert(5L);
        arrayInsertionSort.insert(7L);
        arrayInsertionSort.insert(8L);
        arrayInsertionSort.insert(8L);
        arrayInsertionSort.insert(9L);
        arrayInsertionSort.insert(9L);

        arrayInsertionSort.display();

        arrayInsertionSort.noDups();

        arrayInsertionSort.display();
    }
}
