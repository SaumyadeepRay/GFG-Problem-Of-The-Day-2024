// Find Players With Zero or One Losses

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroOneLosses {

    public static List<List<Integer>> findWinners(int[][] matches) {

        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Update counts based on matches
        // This code snippet iterates over an array of matches and updates a map with
        // the count of occurrences for each element in the second column of the matches
        // array.
        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
        }

        // Initialize winner and loser lists
        // This code snippet creates a new ArrayList and adds it to another ArrayList
        // called "ans" twice.
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        // Populate winners and losers lists
        // This code snippet iterates over the entries in a map and adds the keys to
        // different lists based on their corresponding values (0 or 1) in another list
        // called "ans".
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // This code snippet checks if the value of an entry is equal to 0, and if so,
            // it adds the corresponding key to a list at index 0 of another list.
            if (entry.getValue() == 0) {
                ans.get(0).add(entry.getKey());
            }

            // This code snippet checks if the value of an entry is equal to 1, and if so,
            // adds the corresponding key to a list in the "ans" variable.
            else if (entry.getValue() == 1) {
                ans.get(1).add(entry.getKey());
            }
        }

        // Sort the lists in ascending order
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));

        return ans;
    }

    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        System.out.println("Find Players With Zero or One Losses: " + findWinners(matches));
    }
}
