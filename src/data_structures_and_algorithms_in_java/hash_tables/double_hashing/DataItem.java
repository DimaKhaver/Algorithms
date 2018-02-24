package data_structures_and_algorithms_in_java.hash_tables.double_hashing;

/*
Shows the example of double hashing:
It uses two hash functions: one for finding the initial index and the second for generating the step size.
*/

public class DataItem {
    private int data; // could have more data

    public DataItem(int ii) {
        data = ii;
    }

    public int getKey() {
        return data;
    }
}

class HashTable {
    private DataItem[] hashArray; // array is the hash table
    private int arraySize;
    private DataItem nonItem = new DataItem(-1);

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(String.valueOf(hashArray[j].getKey()));
            else
                System.out.print("**");
        }
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    // non-zero, less than array size, different from hF1
    // array size must be relatively prime to 5, 4, 3, and 2
    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(int key, DataItem item) {
      // (assumes table not full)
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != - 1) {
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        hashArray[hashVal] = item; // insert item
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size

        while (hashArray[hashVal] != null) { // until empty cell, is correct hashVal?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;  // delete item
                return temp; // return item
            }
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        return null;
    }

    public DataItem find(int key) { // find item with key
        // (assumes table not full)
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size

        while(hashArray[hashVal] != null) { // until empty cell, is correct hashVal?
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // yes, return item
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        return null; // can't find the item
    }

}
