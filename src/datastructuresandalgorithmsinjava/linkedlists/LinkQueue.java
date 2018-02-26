package datastructuresandalgorithmsinjava.linkedlists;

/*
 LinkedLists - insertions/deletions: O(N)
 min value can be found/deleted: O(1)
*/

class QLink {
    public long data;
    public QLink next;

    public QLink(long data) {
        this.data = data;
    }
}

class FirstLastList {
    private QLink first;
    private QLink last;

    FirstLastList() {
        first = null ;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long d) {
        QLink newLink = new QLink(d);

        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.data;
        if (first.next == null)
            last = null;

        first = first.next;
        return temp;
    }
}

public class LinkQueue {
    private FirstLastList theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insertFirst(j);
    }

    public long remove() {
        return theList.deleteFirst();
    }
}

