package array;

/**
 * Created by dmitriy on 31.05.17.
 */
public class OrdArray {
    private long [] a;
    private int elems;
    private int currentIndex;


    public OrdArray(int max) {
        a = new long[max];
        elems = 0;
    }

    public int size() {
        return elems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = elems - 1;

        System.out.println("\nupperBound = " + upperBound + " elems = " + elems);

        // Binary search
        while(true) {

            currentIndex = (lowerBound + upperBound) / 2;

            if (elems == 0) {
                return currentIndex = 0;
            }

            if (lowerBound == currentIndex) {
                if (a[currentIndex] > searchKey) {
                    return currentIndex;
                }
            }

            if (a[currentIndex] < searchKey) {
                lowerBound = currentIndex + 1;
                if (lowerBound > upperBound) {
                    return currentIndex += 1;
                }
            } else if (lowerBound > upperBound) {
                return currentIndex;
            } else {
                upperBound = currentIndex - 1;
            }
        }
    }

    public void insert(long value) { // Binary search

        find(value);

        for(int k = elems; k > currentIndex; k--) {
            a[k] = a[k - 1];
        }

        a[currentIndex] = value;

        System.out.println("\nvalue = " + value + " currentIndex = " + currentIndex + "\n");

        elems++;
    }


    public boolean delete(long value) {
        int j = find(value);

        if(j == elems)
            return false;

        else {
            for (int k = j; k < elems; ++k)
                a[k] = a[k + 1];

            elems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < elems; ++j)
            System.out.println(a[j] + "");
    }
}
