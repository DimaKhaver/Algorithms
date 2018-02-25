package data_structures_and_algorithms_in_java.hash_tables.separate_chaining;

// demonstrates hash table with separate chaining

public class Link {
    private int data; // data item
    public Link next; // next link in list

    public Link(int it) {
        data = it;
    }

    public int getKey() {
        return data;
    }
    public void displayLink() {
        System.out.print(data + " ");
    }
}

class SortedList {
    private Link first;

    public void SortedList() {
        first = null;
    }

    public void insert(Link theLink) { // insert link in order
        int key = theLink.getKey();
        Link prev = null; // start at first
        Link current = first;

        while (current != null && key > current.getKey()) { // until end of the list or current > key
            prev = current;
            current = current.next; //  next item
        }

        if (prev == null) // if beginning of list
            first = theLink; // first -> new link
        else
            prev.next = theLink; // prev -> new link

        theLink.next = current; // new link -> current
    }

    public void delete(int key) {
        Link prev = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            prev = current;
            current = current.next;
        }

        if (prev == null) // if beginning of the list
            first = first.next; // delete first link
        else // not at beginning
            prev.next = current != null ? current.next : null; // delete current link
    }

    public Link find(int key) {
        Link current = first; // start at first

        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key)
                return current;
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");

        Link current = first; // start at beginning of list
        while(current != null) { // until end of list
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}

class HashTable {
    private SortedList [] hashArray;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // create array
        for (int j = 0; j < arraySize; j++) { // fill array with lists
            hashArray[j] = new SortedList();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". "); // display cell #
            hashArray[j].displayList(); // display list
        }
    }

    public int hashFunc(int key) { // hash func
        return key % arraySize;
    }

    public void insert(Link theLink) { // insert the link
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink); // insert at hashVal
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}