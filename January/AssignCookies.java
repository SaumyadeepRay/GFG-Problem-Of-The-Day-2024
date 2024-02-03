// Assign Cookies

import java.util.Arrays;

public class AssignCookies {
    
    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                i++;
                j++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println("Assign Cookies: " + findContentChildren(g, s));
    }
}
