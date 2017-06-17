package arrays;

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

    public void merge(long [] b, long [] c) { // merges two different ordered arrays -> one ordered array

        int newArrayLength = b.length + c.length;
      //int maxLength = b.length > c.length ? b.length : c.length;

        for (int i = 0, j = 0; i < newArrayLength; ++i, ++j) { // i - new arrays; j - b and c

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

    public void noDups() { // prevents duplicates in the array

        for (int i = 0; i < this.size(); ++i) {

            for (int j = i+1; j < this.size(); ++j) {

                System.out.println("i = " + i);
                System.out.println("j = " + j + "\n");

                if (a[i] == a[j]) {
                    a[j] = 0;
                }
            }
        }
    }

    public void insert(long value) { // Binary search

        find(value);

        for(int k = elems; k > currentIndex; k--) {
            a[k] = a[k - 1];
        }

        a[currentIndex] = value;
        elems++;
    }

    public boolean delete(long value) {
        int j = find(value);

        if(j == elems)
            return false;

        else {
            for (int k = j; k < elems; k++)
                a[k] = a[k + 1];

            elems--;
            return true;
        }
    }

    public void display() {

        System.out.print("Display!\n");

        for (int j = 0; j < a.length; ++j)
            System.out.println(a[j] + "");
    }
}
