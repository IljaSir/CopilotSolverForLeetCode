class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1000000007;
        int[][][] dp = new int[m][n][maxMove+1];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    for (int[] dir : dirs) {
                        int r = i + dir[0], c = j + dir[1];
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            dp[i][j][k]++;
                        } else if (k > 0) {
                            dp[i][j][k] = (dp[i][j][k] + dp[r][c][k-1]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}