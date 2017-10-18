package data_structures_and_algorithms_in_java.linked_lists;

/*
 it's called doubly - because each node has 2 pointers:
 to PREV node and to NEXT node in the linked list
*/

class DLLink {
    public long dData; // data item
    public DLLink next; // next link
    public DLLink previous; // prev link

    public DLLink(long d) {
        dData = d;
    }
}


public class DoublyLinkedList {
    private DLLink first; // ref to first item
    private DLLink last; // ref to last item

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) { // insert at front of list
        DLLink newLink = new DLLink(dd);

        if (isEmpty())
            last = newLink; // newLink <- last
        else
            first.previous = newLink; // newLink <- old first

        newLink.next = first; // newLink -> old first
        first = newLink; // first -> newLink
    }

    public void insertLast(long dd) { // insert at end of list
        DLLink newLink = new DLLink(dd);

        if (isEmpty()) // if empty link
            first = newLink; // first -> newLink
        else {
            last.next = newLink; // old last -> newLink
            newLink.previous = last; // old last <- newLink
        }
        last = newLink; // newLink <- last
    }

    public DLLink deleteFirst() { // delete first link
        if (!isEmpty()) {
            DLLink temp = first;

            if (first.next == null) // if only 1 item
                last = null; // null <- last
            else
                first.next.previous = null; // null <- old next

            first = first.next; // first -> old next
            return temp;
        } else
            return null;
    }

    public DLLink deleteLast() { // delete last link
        if (!isEmpty()) {
            DLLink temp = last;

            if (first.next == null) // if only 1 item
                first = null; // first -> null
            else
                last.previous.next = null; // old prev -> null

            last = last.previous; // old prev <- last
            return temp;
        } else
            return null;
    }

    public boolean insertAfter(long key, long dd) { // insert dd after certain key
        if (!isEmpty()) {
            DLLink current = first; // start at beginning

            while (current.dData != key) { // until match is found
                current = current.next; // move to next link
                if (current == null)
                    return false; // didn't find it
            }

            DLLink newLink = new DLLink(dd); // make new link

            if (current == last) { // if it last link
                newLink.next = null; // newLink -> null
                last = newLink; // newLink <- last
            } else { // not last link
                newLink.next = current.next; // newLink -> old next
                current.next.previous = newLink; // newLink <- old next
            }

            newLink.previous = current; // old current <- newLink
            current.next = newLink; // old current -> newLink
            return true; // found it, did insertion
        } else
            return false;
    }

    public DLLink deleteKey(long key) {
        if (!isEmpty()) {
            DLLink current = first; // start at beginning

            while (current.dData != key) { // until match is found
                current = current.next; // move to next link
                if (current == null)
                    return null; // didn't find it
            }

            if (current == first) // found it; first item ?
                first = current.next; // first -> old next
            else // not first
                current.previous.next = current.next; // old prev -> old next

            if (current == last) // last item ?
                last = current.previous; // old prev <- last
            else // not last
                current.next.previous = current.previous; // old prev <- old next

            return current;
        } else
            return null;
    }

}
