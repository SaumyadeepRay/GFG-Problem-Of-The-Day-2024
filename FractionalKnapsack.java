// Fractional Knapsack

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int W, Item arr[], int n) {

        // This code snippet sorts an array called "arr" in descending order based on
        // the ratio of each item's value to its weight.
        Arrays.sort(arr, Comparator.comparingDouble(item -> -1.0 * item.value / item.weight));

        double maxValue = 0.0;

        for (int i = 0; i < n; i++) {

            // Base Case
            if (W == 0) {
                break;
            }

            // This code snippet calculates the maximum value that can be obtained by
            // selecting items from an array based on their weight and value, while
            // considering a maximum weight limit.
            int quantity = Math.min(W, arr[i].weight);

            // This code snippet calculates the maximum value by adding the product of the
            // value, quantity, and weight of each element in the array to the existing
            // maxValue.
            maxValue += (1.0 * arr[i].value * quantity) / arr[i].weight;

            W = W - quantity;
        }

        return maxValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);

            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new FractionalKnapsack().fractionalKnapsack(w, arr, n)));
        }
    }

}
