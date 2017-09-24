
package data_structures_and_algorithms_book;

import data_structures_and_algorithms_book.stacks_and_queues.Reverser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dmitriy on 30.05.17.
 */
public class Execution {

    public static void main(String[] args) {

        String input = null, output;

        while (true) {

            System.out.print("Enter a string: ");
            System.out.flush();

            try {
                input = getString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (input != null)
                if (input.equals(""))
                    break;

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();
            System.out.print("Reversed: " + output);
        }
    }
    
    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
