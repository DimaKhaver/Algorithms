package data_structures_and_algorithms_in_java.sorting_algorithms;

public class ArrayInOb {

    private Person[] a;
    private int elems;

    public ArrayInOb(int max) {
        a = new Person[max];
        elems = 0;
    }

    public void insert(String last, String first, int age) {
        a[elems] = new Person(last, first, age);
        elems++;
    }

    public void display() {
        for (int i = 0; i < elems; ++i)
            a[i].displayPerson();
    }

    public void insertionSort() {
        int in, out;

        for (out = 1; out < elems; out++) { // out is dividing line
            Person temp = a[out]; // remove marked person
            in = out; // start shifting at out
            // until smaller one found
            while (in > 0 && a[in -1].getLast().compareTo(temp.getLast()) > 0) {
                a[in] = a[in - 1]; // shift item to the right
                --in; // go left one position
            }

            a[in] = temp;
        }
    }
}
