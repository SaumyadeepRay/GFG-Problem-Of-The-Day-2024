// Recamans Sequence

import java.util.ArrayList;

public class RecamansSequence {

    public static ArrayList<Integer> recamanSequence(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int a0 = 0;
        ans.add(a0);
        for (int i = 1; i < n; i++) {
            int a1 = ans.get(i - 1) - i;
            if (a1 < 0 || ans.contains(a1)) {
                a1 = ans.get(i - 1) + i;
            }
            ans.add(a1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recamans Sequence: " + recamanSequence(n));
    }
}
