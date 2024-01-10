// Split Array Largest Sum

import java.util.Arrays;

public class SplitArrayLargestSum {

    public static int splitArray(int[] arr, int N, int K) {
        // code here
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, arr, K)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // To check if mid is possible to get by splitting array in k or less then k
    // subarray
    public static boolean check(int mid, int[] arr, int k) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            // This code snippet calculates the sum of elements in an array. If the sum
            // exceeds a certain value (mid), it resets the sum to the current element and
            // increments a count variable.
            sum = sum + arr[i];
            if (sum > mid) {
                sum = arr[i];
                count++;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        int N = 4;
        int K = 3;
        int[] arr = { 1, 2, 3, 4 };
        System.out.println("Split Array Largest Sum: " + splitArray(arr, N, K));
    }
}
