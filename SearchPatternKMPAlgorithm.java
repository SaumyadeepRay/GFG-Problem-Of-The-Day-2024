// Search Pattern (KMP-Algorithm)

import java.util.ArrayList;

public class SearchPatternKMPAlgorithm {

    // Approach 1
    public static ArrayList<Integer> search1(String pat, String txt) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            if (pat.equals(txt.substring(i, i + pat.length()))) {
                count++;
                list.add(i + 1);
            }
        }
        if (count == 0) {
            list.add(-1);
            return list;
        } else {
            return list;
        }
    }

    // Approach 2
    public static ArrayList<Integer> search2(String pat, String txt) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;

        while (true) {
            int idx = txt.indexOf(pat, i);
            if (idx == -1) {
                break;
            } else {
                al.add(idx + 1);
                i = idx + 1;
            }
        }

        if (al.size() == 0) {
            al.add(-1);
        }
        return al;
    }

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "geek";
        System.out.println("Search Pattern (KMP-Algorithm): " + search1(pat, txt));
        System.out.println("Search Pattern (KMP-Algorithm): " + search2(pat, txt));
    }
}
