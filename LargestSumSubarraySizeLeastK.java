// Largest Sum Subarray of Size at least K

public class LargestSumSubarraySizeLeastK {

    public static long maxSumWithK(long arr[], long n, long k) {
        int N = (int) n;
        int K = (int) k;

        long[] maxSum = new long[N];
        maxSum[0] = arr[0];

        long currentSum = arr[0];

        // This code snippet calculates the maximum sum of a subarray in an array by
        // iterating through the array and updating the maximum sum at each index.
        for (int i = 1; i < N; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum[i] = currentSum;
        }

        long result = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum = sum + arr[i];
        }

        result = sum;

        for (int i = K; i < N; i++) {
            sum += arr[i] - arr[i - K];
            // The code snippet updates the value of "result" by taking the maximum between
            // "result" and "sum", and then taking the maximum between "result" and the sum
            // of "sum" and "maxSum[i - K]".
            result = Math.max(result, sum);
            result = Math.max(result, sum + maxSum[i - K]);
        }

        return result;
    }

    public static void main(String[] args) {
        long n = 6;
        long arr[] = { 6, -9, -5, 4, -3, 7 };
        long k = 3;
        System.out.println("Largest Sum Subarray of Size at least K: " + maxSumWithK(arr, n, k));
    }
}
