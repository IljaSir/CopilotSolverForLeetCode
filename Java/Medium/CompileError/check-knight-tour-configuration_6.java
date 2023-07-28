class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        int[] diagonal1 = new int[2 * n - 1];
        int[] diagonal2 = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += grid[i][j];
                col[i] += grid[j][i];
                diagonal1[i + j] += grid[i][j];
                diagonal2[i - j + n - 1] += grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i] != n * (n * n - 1) / 2) {
                return false;
            }
            if (col[i] != n * (n * n - 1) / 2) {
                return false;
            }
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            if (diagonal1[i] != n * (n * n - 1) / 2) {
                return false;
            }
            if (diagonal2[i] != n * (n * n - 1) / 2) {
                return false;
            }
        }
        return true;
    }
    public boolean checkValidKnightTour(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        int[] diagonal1 = new int[2 * n - 1];
        int[] diagonal2 = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += grid[i][j];
                col[i] += grid[j][i];
                diagonal1[i + j] += grid[i][j];
                diagonal2[i - j + n - 1] += grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i] != n * (n * n - 1) /
    }
}