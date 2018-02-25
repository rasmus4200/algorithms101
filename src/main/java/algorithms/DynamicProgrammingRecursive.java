package algorithms;

public class DynamicProgrammingRecursive {

    private int grid[][];

    public DynamicProgrammingRecursive(int[][] grid) {
        this.grid = grid;
    }

    public int countPaths(int row, int col) {
        if (!isValidSquare(row, col)) return 0;
        if (isAtEnd(row, col)) return 1;
        return countPaths(row + 1, col) + countPaths(row, col + 1);
    }

    public boolean isValidSquare(int row, int col) {
        return isInBounds(row, col) && !isBlocked(row, col);
    }

    public boolean isBlocked(int row, int col) {
        return this.grid[row][col] == 1;
    }

    public boolean isInBounds(int row, int col) {
        return (row < grid.length && col < grid[0].length);
    }

    public boolean isAtEnd(int row, int col) {
        return grid.length - 1 == row && grid[row].length - 1 == col;
    }

}
