class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    up[i][j] = grid[i][j];
                } else {
                    up[i][j] = grid[i][j] == 0 ? 0 : up[i - 1][j] + 1;
                }
                if (j == 0) {
                    left[i][j] = grid[i][j];
                } else {
                    left[i][j] = grid[i][j] == 0 ? 0 : left[i][j - 1] + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1) {
                    down[i][j] = grid[i][j];
                } else {
                    down[i][j] = grid[i][j] == 0 ? 0 : down[i + 1][j] + 1;
                }
                if (j == n - 1) {
                    right[i][j] = grid[i][j];
                } else {
                    right[i][j] = grid[i][j] == 0 ? 0 : right[i][j + 1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, Math.min(up[i][j], Math.min(down[i
    }
}