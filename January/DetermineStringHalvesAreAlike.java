// Determine if String Halves Are Alike

public class DetermineStringHalvesAreAlike {

    // Approach 1
    public static boolean halvesAreAlike1(String s) {

        s = s.toLowerCase();

        int n = s.length();
        int mid = n / 2;

        int i = 0;
        int j = mid;

        int a = 0;
        int b = 0;

        while (i < j && j < n) {
            if (vowelCheck(s.charAt(i))) {
                a++;
            }
            if (vowelCheck(s.charAt(j))) {
                b++;
            }
            i++;
            j++;
        }

        if (a == b) {
            return true;
        }

        return false;
    }

    public static boolean vowelCheck(char ch) {
        if (ch == ('a') || ch == ('e') || ch == ('i') || ch == ('o') || ch == ('u')) {
            return true;
        }
        return false;
    }

    // Approach 2
    public static boolean halvesAreAlike2(String s) {
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);

        int countFirst = countVowels(firstHalf);
        int countSecond = countVowels(secondHalf);

        return countFirst == countSecond;
    }

    private static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "book";
        System.out.println("Determine if String Halves Are Alike: " + halvesAreAlike1(s));
        System.out.println("Determine if String Halves Are Alike: " + halvesAreAlike2(s));
    }
}
