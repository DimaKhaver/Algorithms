package array;

/**
 * Created by dmitriy on 31.05.17.
 */
public class OrdArray {
    private long [] a;
    private int elems;

    public OrdArray(int max) {
        a = new long[max];
        elems = 0;
    }

    public int size() {
        return elems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = elems -1 ;
        int currentIndex;

        // Binary search
        while(true) {

            currentIndex = (lowerBound + upperBound) / 2;
            if (a[currentIndex] == searchKey)
                return currentIndex;

            else if (lowerBound > upperBound)
                return elems;

            else {
                if (a[currentIndex] < searchKey)
                    lowerBound = currentIndex + 1; // in upper half
                else
                    upperBound = currentIndex - 1; // in lower half
            }
        }
    }

    public void insert(long value) { // Binary search

        int lowerBound = 0;
        int upperBound = elems-1;
        int currentIndex;

        while (true) {

            currentIndex = (lowerBound + upperBound) / 2;

            if (a[currentIndex] == value || a[currentIndex] > value) {

                for (int i = elems; i > currentIndex; i--) {
                        a[i] = a[i - 1];
                }
                a[currentIndex] = value;
                elems++;

                break;
            }

            if (elems == 0) {
                a[lowerBound] = value;
                elems++;
            }

            if (lowerBound > upperBound) {
                a[currentIndex] = value;
                break;
            }

            else {
                if (a[currentIndex] < value)
                    lowerBound = currentIndex + 1;
                else
                    upperBound = currentIndex - 1;
            }
        }
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
