class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] d : dp) {
            for (int[] dd : d) {
                Arrays.fill(dd, -1);
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn, dp);
    }

    private int dfs(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != -1) {
            return dp[startRow][startColumn][maxMove];
        }
        int res = 0;
        res += dfs(m, n, maxMove - 1, startRow - 1, startColumn, dp);
        res += dfs(m, n, maxMove - 1, startRow + 1, startColumn, dp);
        res += dfs(m, n, maxMove - 1, startRow, startColumn - 1, dp);
        res += dfs(m, n, maxMove - 1, startRow, startColumn + 1, dp);
        res %= 1000000007;
        dp[startRow][startColumn][maxMove] = res;
        return res;
    }
}