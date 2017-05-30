import array.HighArray;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        HighArray highArray = new HighArray(20);

        highArray.insert(1500L);
        highArray.insert(30033L);
        highArray.insert(50000L);
        highArray.insert(80000L);
        highArray.insert(323232L);
        highArray.insert(323212L);
        highArray.insert(323212L);
        highArray.insert(323212L);
        highArray.insert(4332151323L);
        highArray.insert(9999999L);
        highArray.insert(323212L);

        highArray.display();

        highArray.removeMax();

        highArray.display();

    }
}
