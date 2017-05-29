import array.HighArray;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        HighArray highArray = new HighArray(20);

        highArray.insert(1500);
        highArray.insert(30033);
        highArray.insert(50000);
        highArray.insert(80000);
        highArray.insert(323232);
        highArray.insert(323212);
        highArray.insert(323212);
        highArray.insert(323212);
        highArray.insert(433215);
        highArray.insert(9999999);
        highArray.insert(323212);


        highArray.display();

        long maxKey = highArray.getMax();
        System.out.println("MaxKey = " + maxKey);

    }
}
