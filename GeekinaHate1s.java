// Geekina Hate 1s

import java.util.Arrays;

public class GeekinaHate1s {

    private static Long dp[][][];

    // This code snippet finds the nth number that satisfies a certain condition. It
    // uses binary search to find the number within a given range.
    public static long findNthNumer(int n, int k) {
        // Code Here.
        long low = 0, high = (long) (1e18);
        dp = new Long[2][65][65];
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = find(mid, k);
            if (count >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // This code snippet converts a given number 'n' into its binary representation,
    // and then uses dynamic programming to find the number of ways to split the
    // binary string into 'k' parts such that each part has at least one '1' in it.
    private static long find(long n, int k) {
        char s[] = Long.toBinaryString(n).toCharArray();
        reset();
        return dp(s, s.length, 1, k);
    }

    // This code snippet is a recursive function that calculates the number of ways
    // to form a number using the digits in the given character array 's', with a
    // given length 'n', a given tightness 'tight', and a given sum 'k'. It
    private static long dp(char s[], int n, int tight, int k) {
        if (k < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[tight][k][n] != null)
            return dp[tight][k][n];
        int ub = (tight == 1 ? (int) (s[s.length - n] - '0') : 1);
        long ans = 0;
        for (int dig = 0; dig <= ub; dig++) {
            if (dig == ub) {
                ans += dp(s, n - 1, tight, k - dig);
            } else {
                ans += dp(s, n - 1, 0, k - dig);
            }
        }
        return dp[tight][k][n] = ans;
    }

    // This code snippet resets the values of a two-dimensional array by setting all
    // elements to null. The array has two dimensions and each dimension has 65
    // elements.
    private static void reset() {
        for (int i = 0; i < 65; i++) {
            Arrays.fill(dp[0][i], null);
            Arrays.fill(dp[1][i], null);
        }
    }

    public static void main(String[] args) {
        System.out.println("Geekina Hate 1s");
    }
}
