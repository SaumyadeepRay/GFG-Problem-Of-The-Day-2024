// Sequence of Sequence

public class SequenceOfSequence {

    public static int numberSequence(int m, int n) {
        // Base Case
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        // This code snippet returns the sum of two recursive function calls:
        // numberSequence(m divided by 2, n minus 1) and numberSequence(m minus 1, n).
        return numberSequence(m / 2, n - 1) + numberSequence(m - 1, n);
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 2;
        System.out.println("Sequence of Sequence: " + numberSequence(m, n));
    }
}
