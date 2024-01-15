// Grinding Geek

public class GrindingGeek {

    public static int max_courses(int n, int total, int[] cost) {
        
        // This code snippet initializes a 2D array called "dp" with dimensions (n + 1)
        // by (total + 1), where n and total are variables.
        int[][] dp = new int[n + 1][total + 1];

        // This code snippet calculates the maximum purchase value based on a given
        // total and cost array. It iterates through the cost array and checks if the
        // cost at the current index is less than or equal to the sum.
        for (int sum = 1; sum <= total; ++sum) {
            for (int index = n - 1; index >= 0; index--) {

                int purchase = 0;
                int notPurchase = 0;

                // This code checks if the cost at the given index is less than or equal to the
                // sum. If true, it calculates the purchase value based on the next index and
                // the discounted cost.
                if (cost[index] <= sum) {
                    purchase = 1 + dp[index + 1][sum - cost[index] + (cost[index] * 9) / 10];
                }

                // This code snippet updates the value of dp[index][sum] by taking the maximum
                // value between purchase and notPurchase, where notPurchase is obtained from
                // dp[index + 1][sum].
                notPurchase = dp[index + 1][sum];
                dp[index][sum] = Math.max(purchase, notPurchase);
            }
        }
        return dp[0][total];
    }

    public static void main(String[] args) {
        int n = 11;
        int total = 10;
        int[] cost = { 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println("Grinding Geek: " + max_courses(n, total, cost));
    }
}
