package data_structures_and_algorithms_in_java.linked_lists;

class SLink {
    public long dData;
    public SLink next;

    public SLink(long dd) {
        dData = dd;
    }
}


class SLinkList {
    private SLink first;

    public SLinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertLast(long dd) {
        SLink newLink = new SLink(dd);
        newLink.next = first;
        first = newLink;
    }

    public long deleteFirst() {
        SLink temp = first;
        first = first.next;
        return temp.dData;
    }
}


public class LinkStack {
    private SLinkList theList;

    public LinkStack() {
        theList = new SLinkList();
    }

    public void push(long j) {
        theList.insertLast(j);
    }

    public long pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return (theList.isEmpty());
    }
}
