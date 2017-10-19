
package data_structures_and_algorithms_in_java;

import data_structures_and_algorithms_in_java.linked_lists.CircularLinkedList;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList(10);

        circularLinkedList.insert(2);
        circularLinkedList.insert(3);
        circularLinkedList.insert(4);
        circularLinkedList.insert(5);
        circularLinkedList.insert(6);
        circularLinkedList.insert(7);
        circularLinkedList.insert(8);
        circularLinkedList.insert(9);
        circularLinkedList.insert(10);
        circularLinkedList.insert(20);

        circularLinkedList.show();

        circularLinkedList.delete(2);
        circularLinkedList.delete(4);
        circularLinkedList.delete(6);
        circularLinkedList.delete(20);

        circularLinkedList.show();

        circularLinkedList.insert(2);
        circularLinkedList.insert(4);
        circularLinkedList.insert(6);
        circularLinkedList.insert(20);

        circularLinkedList.show();
    }
}
