package datastructures;

import java.util.HashMap;
import java.util.Map;

public class PrettyPrinter {

    public static void printMatrix(int[][] matrix) {

        int rowCount = matrix.length; // y
        int columnCount = matrix[0].length; // x

        for (int row = 0; row < rowCount; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < columnCount; col++) {
                sb.append(matrix[row][col] + " ");
            }
            System.out.println(sb.toString());
        }
        System.out.println("");
    }
}
