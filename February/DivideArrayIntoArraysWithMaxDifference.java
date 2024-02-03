// Divide Array Into Arrays With Max Difference

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {

    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        // This code snippet iterates through an array of numbers and checks if the
        // difference between every third number and the number two positions before it
        // is greater than a given value. If it is, it returns an empty 2D array.
        // Otherwise, it adds
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[][] {};
            }
            res.add(new int[] { nums[i - 2], nums[i - 1], nums[i] });
        }
        // This code snippet converts an ArrayList of int arrays into a 2D array and
        // returns it.
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k = 2;
        System.out.println("Divide Array Into Arrays With Max Difference: " + divideArray(nums, k));
    }
}
