// Partition Array for Maximum Sum

public class PartitionArrayForMaximumSum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        // This code snippet calculates the maximum sum of a subsequence of length k in
        // an array arr, where each element is multiplied by its position in the
        // subsequence, and stores the result in dp.
        for (int i = 1; i <= n; i++) {
            int max = 0;
            int sum = 0;
            // This code snippet calculates the maximum sum of a subarray by iterating over
            // a range of values and updating the maximum value and sum based on certain
            // conditions.
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                sum = Math.max(max * j + dp[i - j], sum);
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println("Partition Array for Maximum Sum: " + maxSumAfterPartitioning(arr, k));
    }
}
