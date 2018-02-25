package algorithms;

public class DynamicProgrammingIterative {

    private int grid[][];
    private int paths[][];

    public DynamicProgrammingIterative(int[][] grid) {
        this.grid = grid;
        this.paths = new int[grid.length][grid.length];
    }

    public int countPaths(int row, int col) {
        if (!isValidSquare(row, col)) return 0;
        if (isAtEnd(row, col)) return 1;
        if (isAtBeginning(row, col)) {
            paths[row][col] = 1;
        }
        if (paths[row][col] == 0) {

            int bottomCell = 0;
            int rightCell = 0;

            if (isValidSquare(row + 1, col)) {
                bottomCell = paths[row + 1][col];
            }

            if (isValidSquare(row, col + 1)) {
                rightCell = paths[row][col + 1];
            }

            paths[row][col] = bottomCell + rightCell;
        }
        return countPaths(row - 1, col) + countPaths(row, col - 1);
    }

    public boolean isValidSquare(int row, int col) {
        if (!isInBounds(row, col)) {
            return false;
        }
        if (isBlocked(row, col)) {
            return false;
        }
        return true;
    }

    public boolean isBlocked(int row, int col) {
        return grid[row][col] == 1;
    }

    public boolean isInBounds(int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }
        return (row < grid.length && col < grid[0].length);
    }

    public boolean isAtEnd(int row, int col) {
        return row == 0 && col == 0;
    }

    public boolean isAtBeginning(int row, int col) {
        return row == grid.length - 1 && col == grid[0].length - 1;
    }

    public void print2x2() {
        System.out.println(paths[0][0] + " " + paths[0][1]);
        System.out.println(paths[1][0] + " " + paths[1][1]);
    }

    public void print3x2() {
        System.out.println(paths[0][0] + " " + paths[0][1] + " " + paths[0][2]);
        System.out.println(paths[1][0] + " " + paths[1][1] + " " + paths[1][2]);
        System.out.println(paths[2][0] + " " + paths[2][1] + " " + paths[2][2]);
    }

    public void print8x8() {
        System.out.println(paths[0][0] + " " + paths[0][1] + " " + paths[0][2] + paths[0][3] + " " + paths[0][4] + " " + paths[0][5] + paths[0][6] + " " + paths[0][7]);
        System.out.println(paths[1][0] + " " + paths[1][1] + " " + paths[1][2] + paths[1][3] + " " + paths[1][4] + " " + paths[1][5] + paths[1][6] + " " + paths[1][7]);
        System.out.println(paths[2][0] + " " + paths[2][1] + " " + paths[2][2] + paths[2][3] + " " + paths[2][4] + " " + paths[2][5] + paths[2][6] + " " + paths[2][7]);
        System.out.println(paths[3][0] + " " + paths[3][1] + " " + paths[3][2] + paths[3][3] + " " + paths[3][4] + " " + paths[3][5] + paths[3][6] + " " + paths[3][7]);
        System.out.println(paths[4][0] + " " + paths[4][1] + " " + paths[4][2] + paths[4][3] + " " + paths[4][4] + " " + paths[4][5] + paths[4][6] + " " + paths[4][7]);
        System.out.println(paths[5][0] + " " + paths[5][1] + " " + paths[5][2] + paths[5][3] + " " + paths[5][4] + " " + paths[5][5] + paths[5][6] + " " + paths[5][7]);
        System.out.println(paths[6][0] + " " + paths[6][1] + " " + paths[6][2] + paths[6][3] + " " + paths[6][4] + " " + paths[6][5] + paths[6][6] + " " + paths[6][7]);
        System.out.println(paths[7][0] + " " + paths[0][1] + " " + paths[7][2] + paths[7][3] + " " + paths[0][4] + " " + paths[7][5] + paths[7][6] + " " + paths[7][7]);
    }
}
