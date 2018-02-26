package datastructuresandalgorithmsinjava.stacksandqueues;


// Stack used to reverse a string
public class StackX { // O(1)

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top =-1;
    }

    public void push(char j) {
        if (!isFull())
            stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1) ? true : false;
    }

    public int size() {
        return top+1;
    }

    public char peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom -> top): ");
        for (int j=0; j<size(); j++) {
            System.out.println(peekN(j) + " ");
        }
    }
}
