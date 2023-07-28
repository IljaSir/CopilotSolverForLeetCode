class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1000000007;
        int[][][] dp = new int[m][n][maxMove+1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn, dp, MOD);
    }
    public int helper(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp, int MOD) {
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] >= 0) {
            return dp[startRow][startColumn][maxMove];
        }
        dp[startRow][startColumn][maxMove] = (
            helper(m, n, maxMove - 1, startRow - 1, startColumn, dp, MOD) +
            helper(m, n, maxMove - 1, startRow + 1, startColumn, dp, MOD) +
            helper(m, n, maxMove - 1, startRow, startColumn - 1, dp, MOD) +
            helper(m, n, maxMove - 1, startRow, startColumn + 1, dp, MOD)
        ) % MOD;
        return dp[startRow][startColumn][maxMove];
    }
}