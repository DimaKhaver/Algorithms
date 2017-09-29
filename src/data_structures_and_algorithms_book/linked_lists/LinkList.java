package data_structures_and_algorithms_book.linked_lists;

class Link {

    public int iData; // data item (key)
    public double dData; // data item
    public Link next;  // next link in list


    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}

public class LinkList {

    private Link first; // reference to first link on list

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null ? true : false;
    }

    public void insertFirst(int id, double dd) { // insert at start of list
        Link newLink = new Link(id, dd); // make new link
        newLink.next = first; // newLink -> old first Link
        first = newLink; // first -> newLink
    }

    public Link find(int key) { // find link with this key
        Link current = first; // start at first

        while (current.iData != key) { // while no match
            if(current.next == null) // if end of list
                return null; // didn't find it
            else               // not end of list
                current = current.next; // go to next link
        }
        return current; // found it
    }

    public Link delete(int key) {
        Link current = first; // search for link
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null)
                return null; // didn't find it
            else {
                previous = current; // go to next link
                current = current.next;
            }
        }

        if (current == first) // if first link
            first = first.next; // change first
        else // otherwise
            previous.next = current.next; // bypass it

        return current;
    }

    public Link deleteFirst() { // delete first item
        if (!isEmpty()) {
            Link temp = first; // save reference to link
            first = first.next; // delete it: first -> old next
            return temp; // return deleted link
        }
        else
            return null;
    }

    public void displayList() {
        System.out.println("List (first -> last): ");
        Link current = first; // beginning of list

        while(current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}


