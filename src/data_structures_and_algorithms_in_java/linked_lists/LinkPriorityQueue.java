package data_structures_and_algorithms_in_java.linked_lists;

/*
 LinkedLists - insertions/deletions: O(N)
 min value can be found/deleted: O(1)
*/


class PQLink {
    public PQLink next;
    public PQLink prev;
    public long data;

    public PQLink(long data) {
        this.data = data;
    }
}

class LinkedList {
    private PQLink first;
    private PQLink last;
    private int size = 0;
    private int maxSize = 0;

    public LinkedList(int maxSize) {
        first = last = null;
        this.maxSize = maxSize;
    }

    private void insertLink(PQLink linkToInsertAfter, PQLink newLink) {
        PQLink link;

        if (linkToInsertAfter == null) {
            first.prev = newLink;
            link = first;
            first = newLink;
            first.next = link;

            if (size <= 1) {
                last = link;
                last.next = null;
            }
        } else if (linkToInsertAfter.next == null) {
            newLink.prev = linkToInsertAfter;
            linkToInsertAfter.next = newLink;
        } else {
            PQLink prevLink, nextLink;
            prevLink = linkToInsertAfter;
            nextLink = linkToInsertAfter.next;
            prevLink.next = newLink;
            newLink.prev = prevLink;
            newLink.next = nextLink;
            nextLink.prev = newLink;
        }
        size++;
    }

    private PQLink findLinkToInsertAfter(PQLink newLink) {
        PQLink currentLink = first;

        if (newLink.data < currentLink.data)
            return null;

        while (currentLink.next != null) {
            if (newLink.data == currentLink.data)
                return currentLink;
            else if (newLink.data > currentLink.data && newLink.data < currentLink.next.data)
                return currentLink;

            currentLink = currentLink.next;
        }
        return currentLink;
    }

    public void insert(int value) {
        if (!isFull()) {
            PQLink newLink = new PQLink(value);
            PQLink linkToInsertAfter;

            if (first == null) {
                first = newLink;
                first.next = last; // first.next = null;
                size++;
            } else {
                linkToInsertAfter = findLinkToInsertAfter(newLink);

                if (linkToInsertAfter == null || linkToInsertAfter.data != newLink.data)
                    insertLink(linkToInsertAfter, newLink);
            }
        }
    }

    public void deleteFirst() {
        first = first.next;
        first.next.prev = null;
        first.next = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public long showFirstElement() {
        return this.first.data;
    }

    public int getSize() {
        return size;
    }

}

public class LinkPriorityQueue {
    private LinkedList linkedList;

    LinkPriorityQueue(int max) {
        linkedList = new LinkedList(max);
    }

    public long peekFront() {
        return linkedList.showFirstElement();
    }

    public boolean isEmpty() {
       return linkedList.isEmpty();
    }

    public boolean isFull() {
        return linkedList.isFull();
    }

    public void remove() {
        linkedList.deleteFirst();
    }

    public void insert(int value) {
        linkedList.insert(value);
    }

    public int size() {
        return linkedList.getSize();
    }

}
