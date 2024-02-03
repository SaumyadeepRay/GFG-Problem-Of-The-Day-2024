// Insert Delete GetRandom O(1)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class InsertDeleteGetRandom {

    static class RandomizedSet {

        HashSet<Integer> set;
        ArrayList<Integer> list;

        public RandomizedSet() {
            set = new HashSet<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!set.contains(val)) {
                set.add(val);
                list.add(val);
                return true;
            } else {
                return false;
            }
        }

        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                list.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            // This code snippet generates a random number from a set of integers. If the
            // set has at least one element, it converts the set to an array and returns a
            // random element from the array.
            Random rand = new Random();
            if (set.size() >= 1) {
                Integer[] arr = set.toArray(new Integer[0]);
                return arr[rand.nextInt(arr.length)];
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        RandomizedSet list = new RandomizedSet();
        System.out.println(
                "Insert Delete GetRandom O(1): " + list.insert(1) + " " + list.remove(2) + " " + list.insert(2) + " "
                        + list.getRandom() + " " + list.remove(1) + " " + list.insert(2) + " " + list.getRandom());
    }
}
