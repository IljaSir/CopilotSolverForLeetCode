class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return true;
        }
        if (grid[0][0] == 0) {
            return false;
        }
        if (grid[m - 1][n - 1] == 0) {
            return false;
        }
        if (m == 1 || n == 1) {
            return true;
        }
        if (grid[0][1] == 0 && grid[1][0] == 0) {
            return false;
        }
        if (grid[m - 1][n - 2] == 0 && grid[m - 2][n - 1] == 0) {
            return false;
        }
        for (int i = 1; i < m - 1; i++) {
            if (grid[i][0] == 0 && grid[i - 1][1] == 0 && grid[i + 1][1] == 0) {
                return false;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[0][i] == 0 && grid[1][i - 1] == 0 && grid[1][i + 1] == 0) {
                return false;
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (grid[i][n - 1] == 0 && grid[i - 1][n - 2] == 0 && grid[i + 1][n - 2] == 0) {
                return false;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[m - 1][i] == 0 && grid[m - 2][i - 1] == 0 && grid[m - 2][i + 1] == 0) {
                return false;
            }
        }
        return true;
    }
}