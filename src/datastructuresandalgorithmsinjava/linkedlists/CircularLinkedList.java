package datastructuresandalgorithmsinjava.linkedlists;


/*
 LinkedLists - insertions/deletions: O(N)
 min value can be found/deleted: O(1)
*/

// TODO: testing and setting currentLink
class CLink {
    public CLink next;
    public CLink prev;
    private int data;

    public CLink(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

public class CircularLinkedList {
    private CLink currentLink; // the only access to the list from 2nd element ?
    private CLink first;
    private CLink last;
    private int size = 0;
    private int maxSize = 0;

    public CircularLinkedList(int maxSize) {
        currentLink = first = last = null;
        this.maxSize = maxSize;
    }

    public void insert(int data) {
        if (!isFull()) {
            CLink link = new CLink(data);

            if (isEmpty()) {
                this.first = this.last = link;
                link.next = link.prev = null;
            } else {
                if (size == 1) {
                    this.last = link;
                    link.prev = this.first;
                    link.next = this.first;
                    this.first.prev = link;
                    this.first.next = link;
                }
                else {
                  //if (size == 2)
                  //    step();
                    link.prev = this.last;
                    this.last.next = link;
                    this.last = link;
                    link.next = this.first;
                    this.first.prev = link;
                }
            }
            System.out.println("inserted: " + link.getData());
            size++;
        }
    }

    public void delete(int data) {
        if (!isEmpty()) {
            CLink link = search(data);

            if (link != null) {
                if (size == 1) {
                    link.prev = link.next = null;
                    this.first = this.last = this.currentLink = null;
                } else {
                    if (link == this.first) {
                        this.first = link.next;
                        link.next.prev = last;
                        last.next = link.next;
                        link.prev = link.next = null;
                    } else if (link == this.last) {
                        this.last = link.prev;
                        this.last.next = this.first;
                        this.first.prev = this.last;
                        link.prev = link.next = null;
                    } else {
                        if (link == this.currentLink)
                            step();

                        link.prev.next = link.next;
                        link.next.prev = link.prev;
                        link.next = link.prev = null;
                    }
                }
                size--;
            }
        }
    }

    private void step() {
        if (this.currentLink != this.last)
            this.currentLink = this.currentLink.next;
        else
            System.out.println("Only 1 element in list");
    }

    private CLink search(int data) {
        CLink link = this.first;
        while (link.getData() != data) {
            link = link.next;
            if (link == last && link.getData() != data)
                break;
        }
        return link.getData() == data ? link : null;
    }

    public void show() {
        if (!isEmpty()) {
            System.out.println("\n");
            CLink link = this.first;
            do {
                System.out.println("Show link=" + link.getData());
                link = link.next;
            } while (link != last.next);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
