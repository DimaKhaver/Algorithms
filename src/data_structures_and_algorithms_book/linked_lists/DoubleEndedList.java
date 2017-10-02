package data_structures_and_algorithms_book.linked_lists;


class DLink {

    public long dData; // data
    public DLink next; // next link in list

    public DLink(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }
}


public class DoubleEndedList {

    private DLink first; // ref to first link
    private DLink last; // ref to last link

    public DoubleEndedList() {
        first = null; // no links on list yet
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        DLink newLink = new DLink(dd); // new link

        if (isEmpty())
            last = newLink; // newLink <- last

        newLink.next = first; // newLink -> oldFirst
        first = newLink; // first -> newLink
    }

    public void insertLast(long dd){
        DLink newLink = new DLink(dd);

        if (isEmpty())
            first = newLink; // first -> newLink
        else
            last.next = newLink; // old last -> newLink

        last = newLink; // newLink <- last
    }

    public long deleteFirst() {
        long temp = first.dData;

        if (first.next == null)
            last = null;

        first = first.next;
        return temp;
    }
}
