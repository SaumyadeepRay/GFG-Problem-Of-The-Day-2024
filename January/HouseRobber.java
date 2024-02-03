// House Robber

public class HouseRobber {

    public static int rob(int[] nums) {
        int rob = 0;
        int noRob = 0;
        
        // This code snippet iterates through an array of numbers and calculates the
        // maximum sum of two non-adjacent numbers. It uses two variables, rob and
        // noRob, to keep track of the maximum sum with and without including the
        // current number.
        for (int i = 0; i < nums.length; i++) {
            int newRob = noRob + nums[i];
            int newNoRob = Math.max(noRob, rob);
            rob = newRob;
            noRob = newNoRob;
        }
        return Math.max(rob, noRob);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("House Robber: " + rob(nums));
    }
}
