// Number of Laser Beams in a Bank

public class NumberOfLaserBeamsInBank {

    public static int numberOfBeams(String[] bank) {

        int previous = 0;
        int result = 0;

        for (int i = 0; i < bank.length; i++) {
            int current = 0;
            String str = bank[i];
            for (char ch : str.toCharArray()) {
                if (ch == '1') {
                    current++;
                }
            }

            result = result + (previous * current);

            if (current != 0) {
                previous = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] bank = { "011001", "000000", "010100", "001000" };
        System.out.println("Number of Laser Beams in a Bank: " + numberOfBeams(bank));
    }
}
