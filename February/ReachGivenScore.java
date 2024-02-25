// Reach a Given Score

public class ReachGivenScore {

    public static long count(int n) {

        long[] dp = new long[(int) n + 1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 0;

        // This code iterates through numbers starting from 3 up to n, and updates each
        // element in the dp array by adding the value at index i-3 to it.
        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 3];
        }
        // This code snippet iterates from 5 to n, updating elements in the dp array by
        // adding the value of the element at i-5 to the element at i.
        for (int i = 5; i <= n; i++) {
            dp[i] += dp[i - 5];
        }
        // This code snippet iterates through a range of numbers starting from 10 up to
        // a given value 'n', and updates each element in an array 'dp' by adding the
        // value at an offset of 10.
        for (int i = 10; i <= n; i++) {
            dp[i] += dp[i - 10];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Reach a Given Score: " + count(n));
    }
}
