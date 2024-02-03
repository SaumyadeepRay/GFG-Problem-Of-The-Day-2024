// Evaluate Reverse Polish Notation

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a = 0;
        int b = 0;
        
        // This code snippet performs basic arithmetic operations (+, -, *, /) on a
        // stack of integers represented by tokens. It uses a switch statement to
        // determine the operation to perform and updates the stack accordingly.
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int sum = 0;
                    a = stack.pop();
                    b = stack.pop();
                    sum = a + b;
                    stack.add(sum);
                    break;
                case "-":
                    int sub = 0;
                    a = stack.pop();
                    b = stack.pop();
                    sub = b - a;
                    stack.add(sub);
                    break;
                case "*":
                    int mul = 0;
                    a = stack.pop();
                    b = stack.pop();
                    mul = a * b;
                    stack.add(mul);
                    break;
                case "/":
                    int div = 0;
                    a = stack.pop();
                    b = stack.pop();
                    div = b / a;
                    stack.add(div);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println("Evaluate Reverse Polish Notation: " + evalRPN(tokens));
    }
}
