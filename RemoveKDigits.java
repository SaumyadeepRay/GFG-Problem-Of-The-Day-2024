// Remove K Digits

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String S, int K) {

        if (S.length() == K) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            while (!stack.isEmpty() && K > 0 && stack.peek() > ch) {
                stack.pop();
                K--;
            }
            stack.push(ch);
        }

        while (K-- > 0) {
            stack.pop();
        }

        StringBuilder str = new StringBuilder();

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        str = str.reverse();

        while (str.length() > 1 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String S = "267967958";
        int K = 8;
        System.out.println("Remove K Digits: " + removeKdigits(S, K));
    }
}
