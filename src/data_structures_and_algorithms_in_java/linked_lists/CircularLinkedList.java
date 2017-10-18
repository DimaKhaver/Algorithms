package data_structures_and_algorithms_in_java.linked_lists;

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
    private CLink currentLink; // should be the only access to the list ?
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
              //this.currentLink
            } else {
                if (size == 1) {
                    this.last = link;
                    link.prev = this.first;
                    link.next = this.first;
                    this.first.prev = link;
                    this.first.next = link;
                  //this.currentLink = this.last;
                } else {
                    link.prev = this.last;
                    this.last.next = link;
                    this.last = link;
                    link.next = this.first;
                    this.first.prev = link;
                }
            }
            size++;
        }
    }

    public boolean delete(int data) {
        CLink link = search(data);

        if (link != null) {
            if (size == 1) {
                link.prev = link.next = null;
                this.first = this.last = null;
            }
            else {
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
                    link.prev.next = link.next;
                    link.next.prev = link.prev;
                    link.next = link.prev = null;
                }
            }
            return true;
        } else
            return false;
    }

    private CLink search(int data) {
        CLink link = this.first;
        if (link.getData() != data) {
            while (link.getData() != data || link != this.last) {
                link = link.next;
            }
        }
        return link.getData() == data ? link : null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

}
