// Water the plants

import java.util.Arrays;

public class WaterThePlants {

    public static int min_sprinklers(int gallery[], int n) {

        // range in which sprinklers are attached
        // for every position, it will store the right end of water sprinkle
        // if i position is left end
        int[] range = new int[n];
        Arrays.fill(range, -1);

        for (int i = 0; i < n; ++i) {

            // no sprinkler? then no left or right end
            if (gallery[i] == -1) {
                continue;
            }

            // st -> left end of the current sprinkler in the range
            // end -> right end of the current sprinkler in the range
            int st = Math.max(0, i - gallery[i]);
            int end = Math.min(n, i + gallery[i]);

            // So, lets store the maximum right end for left end
            range[st] = Math.max(range[st], end);
        }

        // res -> count of sprinklers turned on
        // cur -> Currently, we are inside a range which end on cur
        // next -> If we are out of cur, what will be the next range to follow?
        int res = 0, cur = -1, next = -1;

        // iterating in range
        for (int i = 0; i < n; ++i) {

            // highest end we can reach from current pos
            next = Math.max(next, range[i]);

            // if we get out of current range of active sprinkler
            // move to next sprinkler incrementing the cnt of res
            if (i > cur) {
                ++res;
                cur = next;
            }

            // if we out of sprinkler range and this pointer is -1, means
            // not the left end of any, then no water sprinkle here so return -1
            if (i > cur && range[i] == -1)
                return -1;
        }

        // return count of active sprinklers
        return res;

    }

    public static void main(String[] args) {
        int n = 6;
        int gallery[] = { -1, 2, 2, -1, 0, 0 };
        System.out.println("Water the plants: " + min_sprinklers(gallery, n));
    }
}
