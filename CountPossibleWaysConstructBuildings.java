// Count possible ways to construct buildings

public class CountPossibleWaysConstructBuildings {

    static long mod = 1000000007;

    public static int TotalWays(int N) {
        long a = 1;
        long b = 1;
        long c = 0;

        for (int i = 1; i <= N; i++) {
            // This code snippet calculates the remainder of a and b divided by mod, adds
            // them together, and then calculates the remainder of the sum divided by mod.
            // It then updates the values of a and b to be the remainder of b and c divided
            // by mod
            c = ((a % mod) + (b % mod)) % mod;
            a = b % mod;
            b = c % mod;
        }

        int result = (int) ((c * c) % mod);
        return result;
    }

    public static void main(String[] args) {
        int N = 3;
        System.out.println("Count possible ways to construct buildings: " + TotalWays(N));
    }
}
