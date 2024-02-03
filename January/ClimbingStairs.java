// Climbing Stairs

public class ClimbingStairs {

    public static int climbStairs(int n) {

        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }

        // This code snippet initializes an array of integers with a length of n+1. It
        // sets the first two elements of the array to 1.
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        // This code snippet generates a Fibonacci sequence up to the given value of n
        // by adding the previous two numbers in the sequence.
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Climbing Stairs: " + climbStairs(n));
    }
}
