// Convert an Array Into a 2D Array With Conditions

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayInto2DArrayWithConditions {

    public static List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        List<List<Integer>> ans = new ArrayList<>();

        for (int val : nums) {

            if (freq[val] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[val]).add(val);
            freq[val]++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println("Convert an Array Into a 2D Array With Conditions: " + findMatrix(nums));
    }
}
