package datastructuresandalgorithmsinjava.stacksandqueues.other;

import datastructuresandalgorithmsinjava.stacksandqueues.StackX;

public class Reverser {

    private String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX stackX = new StackX(stackSize);

        for (int j = 0; j < input.length(); ++j) {
            char ch = input.charAt(j);
            stackX.push(ch);
        }

        output = "";

        while (!stackX.isEmpty()) {
            char ch = stackX.pop();
            output = output + ch;
        }

        return output;
    }

}
