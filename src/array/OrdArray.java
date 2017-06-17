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

    public void merge(long [] b, long [] c) {

        int newArrayLength = b.length + c.length;
      //int maxLength = b.length > c.length ? b.length : c.length;

        for (int i = 0, j = 0; i < newArrayLength; ++i, ++j) { // i - new array; j - b and c

            if (j >= b.length) {
                if (j>= c.length)
                    break;
                else
                    a[i] = c[j];
            }

            if (j >= c.length) {
                if (j>= b.length)
                    break;
                else
                    a[i] = b[j];
            }

            else if (b[j] == c[j]) {
                a[i] = b[j];
                a[++i] = c[j];
            }

            else if (b[j] > c[j]) {
                a[i] = c[j];
                a[++i] = b[j];
            } else if (c[j] > b[j]) {
                a[i] = c[j];
                a[++i] = b[j];
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

        System.out.print("Display!");

        for (int j = 0; j < a.length; ++j)
            System.out.println(a[j] + "");
    }
}
