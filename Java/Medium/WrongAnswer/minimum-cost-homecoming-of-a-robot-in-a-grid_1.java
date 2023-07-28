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
        for (int i = startPos[0]; i < m; i++) {
            for (int j = startPos[1]; j < n; j++) {
                if (i == startPos[0] && j == startPos[1]) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + rowCosts[i]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + colCosts[j]);
                }
            }
        }
        return dp[homePos[0]][homePos[1]];
    }
}