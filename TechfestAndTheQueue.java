// Techfest and the Queue

public class TechfestAndTheQueue {

    public static long sumOfPowers(long a, long b) {
        // code here
        long sum = 0;
        for (long i = a; i <= b; i++) {
            sum = sum + findPow(i);
        }
        return sum;
    }

    public static long findPow(long val) {
        int count = 0;
        for (int i = 2; i * i <= val; i++) {
            // This code snippet checks if the value "val" is divisible by "i". If it is, it
            // increments the "count" variable and updates the value of "val" by dividing it
            // by "i".
            while (val % i == 0) {
                count = count + 1;
                val = val / i;
            }
        }
        if (val > 1) {
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        long a = 9;
        long b = 12;
        System.out.println("Techfest and the Queue: " + sumOfPowers(a, b));
    }
}
