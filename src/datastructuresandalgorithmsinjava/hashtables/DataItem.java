package datastructuresandalgorithmsinjava.hashtables;

/*
demonstrates hash table with linear probing.
With hashing:
 search time on average (under reasonable assumptions): O(1)
 search time in worst case O(n)
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
    private DataItem[] hashArray; // array holds hash table
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key is -1
    }

    public void displayTable() {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(String.valueOf(hashArray[j].getKey()));
            else
                System.out.print("**");
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % arraySize; // hash function
    }

    public void insert(DataItem item) { // insert a DataItem (assume table not full)
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wrap around if necessary
        }
        hashArray[hashVal] = item; // insert item
    }

    public DataItem delete(int key) { // delete a DataItem
        int hashVal = hashFunc(key); // hash the key

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wrap around if necessary
        }
        return null; // can't find item
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key); // hash the key

        while (hashArray[hashVal] != null) { // until empty cell, found the key ?
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // yes, return item
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
