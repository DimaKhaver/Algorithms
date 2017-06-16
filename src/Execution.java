import array.OrdArray;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        OrdArray ordArray = new OrdArray(10);

        ordArray.insert(77L);
        ordArray.insert(99L);
        ordArray.insert(44L);
        ordArray.insert(4L);
      //ordArray.insert(23L);
      //ordArray.insert(12L);
      //ordArray.insert(1L);
      //ordArray.insert(100L);

        ordArray.display();
    }
}
