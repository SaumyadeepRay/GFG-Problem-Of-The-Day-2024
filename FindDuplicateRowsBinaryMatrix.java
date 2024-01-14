// Find duplicate rows in a binary matrix

import java.util.ArrayList;
import java.util.HashSet;

public class FindDuplicateRowsBinaryMatrix {

    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < matrix[0].length; j++) {
                str.append(matrix[i][j]);
            }
            if(set.contains(str.toString())) {
                list.add(i);
            } else {
                set.add(str.toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int R = 2;
        int C = 2;
        int matrix[][] = { { 1, 0 }, { 1, 0 } };
        System.out.println("Find duplicate rows in a binary matrix : " + repeatedRows(matrix, R, C));
    }
}
