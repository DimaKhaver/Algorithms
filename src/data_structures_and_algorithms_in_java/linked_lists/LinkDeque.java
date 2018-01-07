package data_structures_and_algorithms_in_java.linked_lists;

/*
 LinkedLists - insertions/deletions: O(N)
 min value can be found/deleted: O(1)
*/

class DDLink {
    public DDLink next;
    public DDLink prev;
    public long data;

    public DDLink(long data) {
        this.data = data;
    }
}

class DDoublyLinkedList {
    private DDLink first;
    private DDLink last;
    private int size = 0;
    private int maxSize = 0;

    public DDoublyLinkedList(int maxSize) {
        first = last = null;
        this.maxSize = maxSize;
    }

    public void insertFirstLink(long data) {
        if (!isFull()) {
            DDLink newLink = new DDLink(data);

            if (size == 0) {
                first = newLink;
                last = newLink;
                newLink.prev = null;
                newLink.next = null;
            } else {
                newLink.next = first;
                first = newLink;
                newLink.prev = null;
            }
            size++;
        }
    }

    public void insertLastLink(long data) {
        if (!isFull()) {
            DDLink newLink = new DDLink(data);

            if (size == 0) {
                first = newLink;
                last = newLink;
                newLink.next = null;
                newLink.prev = null;
            } else {
                newLink.prev = last;
                newLink.next = null;
                last.next = newLink;
            }
            size++;
        }
    }

    public void deleteFirstLink() {
        if (!isEmpty()) {
            //DDLink link = first;
            if (size == 1)
                first = last = null;
            else {
                first = first.next;
                first.next.prev = null;
            }
        }
    }

    public void deleteLastLink( ) {
        if (!isEmpty()) {
            if (size == 1)
                first = last = null;
            else {
                last.prev.next = null;
                last = last.prev;
            }
        }
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return first == null || size == 0;
    }

    public int getSize() {
        return size;
    }
}

public class LinkDeque {
    private DDoublyLinkedList doublyLinkedList;

    public LinkDeque(int maxSize) {
        doublyLinkedList = new DDoublyLinkedList(maxSize);
    }

    public void insertLeft(long data) {
        doublyLinkedList.insertFirstLink(data);
    }

    public void insertRight(long data) {
        doublyLinkedList.insertLastLink(data);
    }

    public void removeLeft() {
        doublyLinkedList.deleteFirstLink();
    }

    public void removeRight() {
        doublyLinkedList.deleteLastLink();
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    public boolean isFull() {
        return doublyLinkedList.isFull();
    }

    public int size() {
        return doublyLinkedList.getSize();
    }
}
