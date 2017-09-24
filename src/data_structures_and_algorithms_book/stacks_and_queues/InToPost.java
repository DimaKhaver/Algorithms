package data_structures_and_algorithms_book.stacks_and_queues;

// infix to postfix conversion
public class InToPost {

    private StackX theStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }

    public String doTrans() {

        for (int j=0; j < input.length(); ++j) {
            char ch = input.charAt(j);
            theStack.displayStack("For" + ch + " "); // diagnostic

            switch (ch) {
                case '+': // it's + or -
                case '-':
                    gotOper(ch, 1); // go pop operators
                    break; // (precedence 1)

                case '*': // it's * or /
                case '/':
                    gotOper(ch, 2); // go pop operators
                    break; // (precedence 2)

                case '(': // it's a left paren
                    theStack.push(ch); // push it
                    break;
                case ')': // it's a right paren
                    gotParen(ch); // go pop operand
                    break;

                default: // must be an operand
                    output = output + ch; // write it to output
                    break;
            }
        }

        while(!theStack.isEmpty()) { // pop remaining opers
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End ");

        return output;
    }

    public void gotOper(char opThis, int prec1) { // got operator from input

        while(!theStack.isEmpty()) {
            char opTop = theStack.pop();

            if (opTop == '(') {
                theStack.push(opTop); // restore '('
                break;
            }
            else { // it's an operator
                int prec2; // precedence of new op

                if (opTop == '+' || opTop == '-') // find new op prec
                    prec2 = 1;
                else
                    prec2 = 2;

                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                }
                else
                    output = output + opTop;
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch) {

        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }
}
