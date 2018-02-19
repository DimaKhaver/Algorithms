package data_structures_and_algorithms_in_java.sorting_algorithms;

/*
Cocktail Sort is a variation of Bubble sort. The Bubble sort algorithm always traverses elements from left and moves
the largest element to its correct position in first iteration and second largest in second iteration and so on.
Cocktail Sort traverses through a given array in both directions alternatively

Worst and Average Case Time Complexity: O(N*N).
Best Case Time Complexity: O(N)(best case occurs when array is already sorted)
Auxiliary Space: O(1)
Sorting In Place: Yes
Stable: Yes
*/

public class CocktailSort {
    void cocktailSort(int a[]) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped) {
            // reset the swapped flag on entering the
            // loop, because it might be true from a
            // previous iteration.
            swapped = false;
            // loop from bottom to top same as
            // the bubble sort
            for (int i = start; i < end-1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
            // if nothing moved, then array is sorted.
            if (!swapped)
                break;
            // otherwise, reset the swapped flag so that it
            // can be used in the next stage
            swapped = false;
            // move the end point back by one, because
            // item at the end is in its rightful spot
            end = end-1;
            // from top to bottom, doing the
            // same comparison as in the previous stage
            for (int i = end-1; i >=start; i--) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
            // increase the starting point, because
            // the last stage would have moved the next
            // smallest number to its rightful spot.
            start = start+1;
        }
    }
    /* Prints the array */
    public void printArray(int a[]) {
        int n = a.length;
        for (int i=0; i<n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
