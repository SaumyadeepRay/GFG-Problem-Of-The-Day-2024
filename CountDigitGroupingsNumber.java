// Count digit groupings of a number

import java.util.Arrays;

public class CountDigitGroupingsNumber {

    public static int TotalCount(String str) {
        int i;
        int j;
        int ans = 1;
        int n = str.length();
        int[][] sums = new int[n][n];

        // This code snippet calculates the sums of all possible substrings of a given
        // string, where each substring is represented by a 2D array.
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                if (i == j) {
                    sums[i][j] = str.charAt(j) - '0';
                } else {
                    sums[i][j] = sums[i][j - 1] + (str.charAt(j) - '0');
                }
            }
        }

        int[][] dp = new int[n][n];

        // This code snippet fills the first row of a 2D array with 1s, and then
        // iterates through the remaining rows and columns to calculate the values of
        // each element based on certain conditions. Finally, it adds up the values in
        // the last
        Arrays.fill(dp[0], 1);
        for (i = 1; i < n; i++) {
            for (j = i; j < n; j++) {
                for (int k = 0; k <= i - 1; k++) {
                    if (sums[k][i - 1] <= sums[i][j]) {
                        dp[i][j] += dp[k][i - 1];
                    }
                }

            }
            ans += dp[i][n - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "1119";
        System.out.println("Count digit groupings of a number: " + TotalCount(str));
    }
}
