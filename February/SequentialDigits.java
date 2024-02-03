// Sequential Digits

import java.util.ArrayList;
import java.util.List;

class SequentialDigits {

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> a = new ArrayList<>();

        // This code snippet generates a list of numbers between a given range (low and
        // high) where each number is formed by concatenating consecutive digits from 1
        // to 9.
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            int nextDigit = i + 1;

            // This code snippet generates a list of numbers between "low" and "high" by
            // appending digits to "num" until "num" exceeds "high" or "nextDigit" exceeds
            // 9.
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit;
                if (low <= num && num <= high) {
                    a.add(num);
                }
                ++nextDigit;
            }
        }

        a.sort(null);
        return a;
    }

    public static void main(String[] args) {
        int low = 1000;
        int high = 13000;
        System.out.println("Sequential Digits: " + sequentialDigits(low, high));
    }
}