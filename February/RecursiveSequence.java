// Recursive Sequence

public class RecursiveSequence {

    public static long sequence(int n) {
        long mod = 1000000007;
        return func(n, 1, 0, 1) % mod;
    }

    public static long func(int n, int iterations, long sum, int start) {

        // Base case
        if (n == 0) {
            return sum;
        }

        int it = iterations;
        long pro = 1;
        long mod = 1000000007;

        // This code snippet calculates the product of "start" and "pro" modulo "mod"
        // for "it" number of iterations. The value of "start" is incremented after each
        // iteration.
        while (it > 0) {
            pro = pro * start;
            pro = pro % mod;
            start++;
            it--;
        }

        sum = sum + pro;
        return func(n - 1, iterations + 1, sum, start);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recursive sequence: " + sequence(n));
    }
}
