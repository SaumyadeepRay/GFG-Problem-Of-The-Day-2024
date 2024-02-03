// Longest Increasing Subsequence

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        // Patience Sorting

        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            /*
             * Why lower bound?
             * We want an increasing subsequence, and hence
             * we want to eliminate the duplicates as well.
             * lower_bound returns the index of "next greater or equal to."
             */
            int index = binarySearch(sorted, nums[i]);

            if (index == sorted.size()) {
                sorted.add(nums[i]); // greatest: so insert it
            } else {
                sorted.set(index, nums[i]); // replace
            }
        }

        return sorted.size();
    }

    private static int binarySearch(List<Integer> sorted, int target) {
        int left = 0;
        int right = sorted.size();
        int result = sorted.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("Longest Increasing Subsequence: " + lengthOfLIS(nums));
    }
}
