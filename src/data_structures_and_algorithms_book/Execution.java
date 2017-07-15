package data_structures_and_algorithms_book;

import data_structures_and_algorithms_book.simple_sorting.ArrayInOb;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        int maxSize = 100;

        ArrayInOb arrayInOb = new ArrayInOb(maxSize);

        arrayInOb.insert("Evans", "Patty", 24);
        arrayInOb.insert("Smith", "Doc", 59);
        arrayInOb.insert("Smith", "Lof", 30);
        arrayInOb.insert("Yee", "Paul", 44);
        arrayInOb.insert("Hashimoto", "Sato", 20);
        arrayInOb.insert("Stimson", "Henry", 31);
        arrayInOb.insert("Velasquez", "Jose", 33);
        arrayInOb.insert("Vang", "Minh", 42);

        System.out.print("\nBefore sorting:\n");

        arrayInOb.display();

        arrayInOb.insertionSort();

        System.out.print("\nAfter sorting:\n");

        arrayInOb.display();

    }
}
