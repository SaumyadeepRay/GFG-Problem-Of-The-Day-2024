// Set Mismatch

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        int dup = -1;
        int missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            
            int count = 0;
            
            // This code snippet counts the number of times a specific value "i" appears in
            // an array "nums" by iterating through each element and incrementing a counter
            // if a match is found.
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            
            // This code snippet checks the value of the variable "count". If it is equal to
            // 2, it assigns the value of "i" to the variable "dup". If "count" is equal to
            // 0, it assigns the value of "
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                missing = i;
            }
        }

        return new int[] { dup, missing };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println("Set Mismatch: " + findErrorNums(nums));
    }
}
