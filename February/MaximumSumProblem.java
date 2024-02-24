// Maximum Sum Problem

public class MaximumSumProblem {

    public static int maxSum(int n) {
        return findSUm(n);
    }

    // The function recursively calculates the maximum sum of dividing a number by
    // 2, 3, and 4, and compares it with the sum of the results of the same
    // operation on the divided numbers.
    public static int findSUm(int n) {
        // Base case
        if (n <= 11) {
            return n;
        }
        int sum1 = 0;
        int sum2 = 0;
        sum1 = n / 2 + n / 3 + n / 4;
        // This line of code calculates the sum of three recursive calls to the function
        // `findSum` with different arguments `n/2`, `n/3`, and `n/4`, and assigns the
        // result to the variable `sum2`.
        sum2 = findSUm(n / 2) + findSUm(n / 3) + findSUm(n / 4);
        int maximum = Math.max(sum1, sum2);
        return maximum;
    }

    public static void main(String[] args) {
        int n = 24;
        System.out.println("Maximum Sum Problem: " + maxSum(n));
    }
}
