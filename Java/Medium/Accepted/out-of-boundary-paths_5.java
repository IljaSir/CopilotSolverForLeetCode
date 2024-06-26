class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1000000007;
        int[][][] dp = new int[m][n][maxMove + 1];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            dp[i][j][k] = (dp[i][j][k] + 1) % MOD;
                        } else {
                            dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}