package data_structures_and_algorithms_in_java.trees.two_three_four_trees;

// Objects of the DataItem class represent the data items stored in nodes
public class DataItem {
    public long data;

    public DataItem(long dd) {
      //super();
        data = dd;
    }

    public void displayItem() {
        System.out.println("/" + data);
    }
}


