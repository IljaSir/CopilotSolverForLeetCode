class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int m = rowCosts.length;
        int n = colCosts.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[startPos[0]][startPos[1]] = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j] + rowCosts[i]);
                }
                if (j < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j] + colCosts[j]);
                }
            }
        }
        return dp[homePos[0]][homePos[1]];
    }
}