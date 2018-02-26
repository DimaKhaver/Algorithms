package datastructuresandalgorithmsinjava.trees.twothreefourtrees;

// An object of the Tree234 class represents the entire tree
public class Tree234 {
    private Node root = new Node();

    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else
                if (curNode.isLeaf())
                    return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }
    //insert a DataItem
    public void insert(long value) {
        Node curNode = root;
        DataItem tempItem = new DataItem(value);

        while (true) {
            if (curNode.isFull()) { //  if node full
                split(curNode); // split it
                curNode = curNode.getParent(); // back up
                curNode = getNextChild(curNode, value); // search once
            } else if (curNode.isLeaf()) // if node is leaf
                break; // go insert
                // node is not full, not a leaf; so go to lower level
            else
                curNode = getNextChild(curNode, value);
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node thisNode) {
        // assumes node is full
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem(); // remove items from
        itemB = thisNode.removeItem(); // this mode
        child2 = thisNode.disconnectChild(2); // remove children
        child3 = thisNode.disconnectChild(3); // from this node

        Node newRight = new Node(); // make new node

        if (thisNode == root) { // if this is the root
            root = new Node(); // make new root
            parent = root; // root if our parent
            root.connectChild(0, thisNode); // connect to parent
        } else
            parent = thisNode.getParent(); // this node not the root - get parent

        // deal with parent
        itemIndex = parent.insertItem(itemB); // item B to parent
        int n = parent.getNumItems(); // total items ?

        for (int j = n - 1; j < itemIndex; j--) { // move parent's connections
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j+1, temp); // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);
        // deal with newRight
        newRight.insertItem(itemC); // item C to newRight
        newRight.connectChild(0, child2); // connect to 0 and 1
        newRight.connectChild(1, child3); // on newRight
    }
    // get appropriate child of node during search for value
    public Node getNextChild(Node theNode, long theValue) {
        int j;
        // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++) { // for each item in node
            if (theValue < theNode.getItem(j).data) // are we less
                return theNode.getChild(j); // return left child
        }
        return theNode.getChild(j); // return right child
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.println("level = " + level + "child = " + childNumber + " ");
        thisNode.displayNode(); // display this node

        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j=0; j<numItems; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }
}
