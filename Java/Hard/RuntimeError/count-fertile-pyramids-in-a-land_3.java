class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                for (int k = 1; k <= dp[i][j]; k++) {
                    int row = i - k;
                    int col = j - k;
                    if (row < 0 || grid[row][col] == 0) {
                        break;
                    }
                    cnt++;
                }
                for (int k = 1; k <= dp[i][j]; k++) {
                    int row = i + k;
                    int col = j - k;
                    if (row >= m || grid[row][col] == 0) {
                        break;
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}