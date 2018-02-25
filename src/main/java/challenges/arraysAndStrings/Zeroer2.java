package challenges.arraysAndStrings;


public class Zeroer2 {

    // Solution: This solution uses the first row and column of the matrix as a means
    // of storing with row and col need to nullified.

    // 1. Check the first row and column for zeros (will nullify later if necessary).
    // 2. Iterate the rest of the matrix setting the first row and column elements to
    //    zero as we come across them. This works because it doesn't matter where the 0,
    //    occurs in a row or column. Only that it appears.
    // 3. Nullify any rows with zeros.
    // 4. Nullify any columns with zeros.
    // 5. Nullify the first row and column if it needs it.

    public void zeroOut(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // Check if first row has a zero
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Now check the rest of the array and mark any other rows and cols containing zeroes
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                zeroOutRow(row, matrix);
            }
        }

        // Nullify columns based on values in first row
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                zeroOutCol(col, matrix);
            }
        }

        // Nullify first row
        if (rowHasZero) {
            zeroOutRow(0, matrix);
        }

        // Nullify first column
        if (colHasZero) {
            zeroOutCol(0, matrix);
        }
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
