// K Inverse Pairs Array

public class KInversePairsArray {

    public static int kInversePairs(int n, int k) {
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        // This code snippet calculates the value of dp[i][j] by iterating through three
        // nested loops and updating the value based on the previous values of
        // dp[i-1][j-x], where x is between 0 and the minimum of j and i-
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                
                // This code snippet updates the value of dp[i][j] by adding dp[i-1][j-x] for
                // each x from 0 to the minimum of j and i-1, where dp is a two-dimensional
                // array.
                for (int x = 0; x <= Math.min(j, i - 1); x++) {
                
                    // This code snippet updates the value of dp[i][j] by adding the value of dp[i -
                    // 1][j - x] if j - x is greater than or equal to 0. The result is then taken
                    // modulo 100000000
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % 1000000007;
                    }
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        System.out.println("K Inverse Pairs Array: " + kInversePairs(n, k));
    }
}
