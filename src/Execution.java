import data_structures_and_algorithms.simple_sorting.ArrayInsertionSort;
import data_structures_and_algorithms.simple_sorting.ArraySelectionSort;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        int maxSize = 100;

        ArrayInsertionSort arr;

        arr = new ArrayInsertionSort(maxSize);

        arr.insert(1);
        arr.insert(3);
        arr.insert(2);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);
        arr.insert(7);
        arr.insert(8);
        arr.insert(11);
        arr.insert(100);
        arr.insert(130);
        arr.insert(103);
        arr.insert(122);
        arr.insert(9);

        arr.display();
        arr.insertSort();
        arr.display();
    }
}
