// Smallest window containing 0, 1 and 2

public class SmallestWindowContaining {

    public static int smallestSubstring(String str) {
        int zero = -1;
        int one = -1;
        int two = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zero = i;
            } else if (str.charAt(i) == '1') {
                one = i;
            } else {
                two = i;
            }
            if (zero != -1 && one != -1 && two != -1) {
                // This code snippet calculates the minimum value between "ans" and the
                // difference between "i + 1" and the minimum value between "zero", "one", and
                // "two".
                ans = Math.min(ans, i + 1 - Math.min(zero, Math.min(one, two)));
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "10212";
        System.out.println("Smallest window containing 0, 1 and 2: " + smallestSubstring(s));
    }
}