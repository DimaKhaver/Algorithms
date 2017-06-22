import data_structure_and_algorithms.arrays.OrdArray;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        OrdArray ordArray = new OrdArray(10);

      //long [] b = { 2, 4, 6, 8, 10 };
      //long [] c = { 3, 5, 8 };

      //ordArray.merge(b, c);


        ordArray.insert(1L);
        ordArray.insert(4L);
        ordArray.insert(2L);
        ordArray.insert(1L);
        ordArray.insert(5L);
        ordArray.insert(8L);
        ordArray.insert(2L);
        ordArray.insert(1L);
        ordArray.insert(9L);
        ordArray.insert(9L);

      //ordArray.display();

      //ordArray.noDups();

        ordArray.display();
    }
}
