import array.OrdArray;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        OrdArray ordArray = new OrdArray(8);

        ordArray.insert(89L);
        ordArray.insert(1L);
        ordArray.insert(6L);
        ordArray.insert(12L);
        ordArray.insert(3L);
        ordArray.insert(5L);
        ordArray.insert(4L);
        ordArray.insert(800L);
        ordArray.insert(7L);


        ordArray.display();
    }
}
