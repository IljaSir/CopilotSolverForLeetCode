class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        // 1. initialize the grid
        int[][] grid = new int[n][n];
        for (int[] row : grid) {
            Arrays.fill(row, n);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        // 2. calculate each row
        for (int r = 0; r < n; r++) {
            int left = 0;
            for (int c = 0; c < n; c++) {
                left = grid[r][c] == 0 ? 0 : left + 1;
                grid[r][c] = Math.min(grid[r][c], left);
            }
            int right = 0;
            for (int c = n - 1; c >= 0; c--) {
                right = grid[r][c] == 0 ? 0 : right + 1;
                grid[r][c] = Math.min(grid[r][c], right);
            }
        }
        // 3. calculate each column
        for (int c = 0; c < n; c++) {
            int up = 0;
            for (int r = 0; r < n; r++) {
                up = grid[r][c] == 0 ? 0 : up + 1;
                grid[r][c] = Math.min(grid[r][c], up);
            }
            int down = 0;
            for (int r = n - 1; r >= 0; r--) {
                down = grid[r][c] == 0 ? 0 : down + 1;
                grid[r][c] = Math.min(grid[r][c], down);
            }
        }
        // 4. find the max
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                max = Math.max(max, grid[r][c]);
            }
        }
        return max;
    }
}