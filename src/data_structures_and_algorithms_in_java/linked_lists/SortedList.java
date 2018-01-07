package data_structures_and_algorithms_in_java.linked_lists;

/*
 LinkedLists - insertions/deletions: O(N)
 min value can be found/deleted: O(1)
*/

class SLLink {
    public long dData;
    public SLLink next;

    public SLLink(long data) {
        dData = data;
    }
}


public class SortedList {
    private SLLink first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long key) {
        SLLink newLink = new SLLink(key);
        SLLink prev = null;
        SLLink current = first;

        while(current != null && key > current.dData) {
            prev = current;
            current = current.next;
        }

        if (prev == null)
            first = newLink;
        else
            prev.next = newLink;

        newLink.next = current;
    }

    public SLLink remove() {
        SLLink temp = first;
        first = first.next;
        return temp;
    }
}
