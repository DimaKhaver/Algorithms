package array;

/**
 * Created by dmitriy on 30.05.17.
 */

/*  Project 2.2 */

public class HighArray {

    private long [] a;
    private int elems;

    public HighArray( int max ) {
        a = new long[max];
        elems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < elems; ++j)
            if (a[j] == searchKey)
                break;

        return j != elems;
    }

    public void insert(long value) {
        a[elems] = value;
        elems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < elems; ++j)
            if (value == a[j]) // we found it
                break;

        if (j == elems)
            return false;
        else {
            for (int k = j; k < elems; ++k)
                a[k] = a[k + 1];

            elems--;
            return true;
        }
    }

    public void removeMax() { // find&delete max key from an array
        // Linear Search
        long maxKey = a[0];

        for (int i = 1; i < elems; ++i)
            if (maxKey < a[i]) {
                maxKey = a[i];
                System.out.println("max key = " + maxKey);

                for(int j = i; j < elems; ++j)
                    a[j] = a[j+1];

                elems--;
            }
    }

    public void display() {
        for (int j = 0; j < elems; ++j)
            System.out.println(a[j] + " ");
    }

}
