package datastructuresandalgorithmsinjava.sortingalgorithms;

/*
Time Complexity – there are no nested loop (only one while) it may seem that this is a linear O(N) time algorithm.
The time complexity is O(N^2), our variable – ‘index’ does not always get incremented, it gets decremented too.
However this sorting algorithm is adaptive and performs better if the array is already/partially sorted.
Auxiliary Space –  This is an in-place algorithm. So O(1) auxiliary space is needed.
*/

public class GnomeSort {
    public void gnomeSort(int arr[], int n) {
        int index = 0;
        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index-1])
                index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = temp;
                index--;
            }
        }
        return;
    }
}
