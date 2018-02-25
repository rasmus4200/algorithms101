package algorithms;

public class DynamicProgrammingMemoized {

    private int grid[][];
    private int paths[][];

    public DynamicProgrammingMemoized(int[][] grid) {
        this.grid = grid;
        this.paths = new int[grid.length][grid[0].length]; // assume square
    }

    public int countPaths(int row, int col) {
        if (!isValidSquare(row, col)) return 0;
        if (isAtEnd(row, col)) return 1;
        if (this.paths[row][col] == 0) {
            this.paths[row][col] = countPaths(row + 1, col) + countPaths(row, col + 1);
        }
        return this.paths[row][col];
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
