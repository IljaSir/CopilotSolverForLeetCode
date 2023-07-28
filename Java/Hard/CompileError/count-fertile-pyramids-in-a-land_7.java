class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    up[i][j] = (i == 0 ? 0 : up[i - 1][j]) + 1;
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    down[i][j] = (i == m - 1 ? 0 : down[i + 1][j]) + 1;
                    right[i][j] = (j == n - 1 ? 0 : right[i][j + 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int h = 1; i + h < m && j - h >= 0 && j + h < n; h++) {
                        if (grid[i + h][j - h] == 1 && grid[i + h][j + h] == 1) {
                            if (up[i + h][j - h] >= h + 1 && up[i + h][j + h] >= h + 1 && right[i + h][j + h] >= h + 1 && left[i + h][j - h] >= h + 1) {
                                ans++;
                            }
                        }
                    }
                    for (int h = 1; i - h >= 0 && j - h >= 0 && j + h < n; h
    }
}