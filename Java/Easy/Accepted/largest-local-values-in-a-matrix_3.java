class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = grid[i - 1][j - 1];
                max = Math.max(max, grid[i - 1][j]);
                max = Math.max(max, grid[i - 1][j + 1]);
                max = Math.max(max, grid[i][j - 1]);
                max = Math.max(max, grid[i][j]);
                max = Math.max(max, grid[i][j + 1]);
                max = Math.max(max, grid[i + 1][j - 1]);
                max = Math.max(max, grid[i + 1][j]);
                max = Math.max(max, grid[i + 1][j + 1]);
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }
}