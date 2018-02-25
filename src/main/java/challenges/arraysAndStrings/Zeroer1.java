package challenges.arraysAndStrings;

import java.util.ArrayList;

public class Zeroer1 {

    public class Pair {

        public int y;
        public int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public void zeroOut(int[][] matrix) {
        ArrayList<Pair> zeros = getZeros(matrix);

        for (int i = 0; i < zeros.size(); i++) {
            zeroOutRow(zeros.get(i).y, matrix);
            zeroOutCol(zeros.get(i).x, matrix);
        }
    }

    public ArrayList<Pair> getZeros(int[][] matrix) {
        ArrayList<Pair> results = new ArrayList<Pair>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    results.add(new Pair(row, col));
                }
            }
        }

        return results;
    }

    public void zeroOutRow(int y, int[][] matrix) {
        int[] row = matrix[y];

        for (int col = 0; col < row.length; col++) {
            matrix[y][col] = 0;
        }
    }

    public void zeroOutCol(int x, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][x] = 0;
        }
    }

}
