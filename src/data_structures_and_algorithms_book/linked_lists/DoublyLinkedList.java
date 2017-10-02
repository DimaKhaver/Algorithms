package data_structures_and_algorithms_book.linked_lists;

class DLLink {
    public long dData; // data item
    public DLLink next; // next link
    public DLLink previous; // prev link

    public DLLink(long d) {
        dData = d;
    }
}


public class DoublyLinkedList {
    private DLLink first;
    private DLLink last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        DLLink newLink = new DLLink(dd);

        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {
        DLLink newLink = new DLLink(dd);

        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public DLLink deleteFirst() {
        DLLink temp = first;

        if (first.next == null)
            last = null;
        else
            first.next.previous = null;

        first = first.next;
        return temp;
    }

    public DLLink deleteLast() {
        DLLink temp = last;

        if (first.next == null)
            first = null;
        else
            last.previous.next = null;

        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long dd) {
        DLLink current = first;

        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return false;
        }

        DLLink newLink = new DLLink(dd);

        if (current == last) {
            newLink.next = null;
            last = newLink;
        }
        else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public DLLink deleteKey(long key) {
        DLLink current = first;

        while (current.dData != key) {
            current = current.next;
            if(current == null)
                return null;
        }

        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;

        return current;
    }

}
