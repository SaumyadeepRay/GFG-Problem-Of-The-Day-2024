// Daily Temperatures

import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();

        // This code snippet calculates the number of days until the next higher
        // temperature for each day in an array of temperatures. It uses a stack to keep
        // track of the indices of temperatures that have not yet found a higher
        // temperature.
        for (int i = 0; i < temps.length; i++) {
            
            // This code snippet checks if the stack is not empty and if the value at the
            // current index is greater than the value at the top of the stack. If both
            // conditions are true, it calculates the difference between the current index
            // and the top of the stack
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println("Daily Temperatures: " + dailyTemperatures(temperatures));
    }
}
