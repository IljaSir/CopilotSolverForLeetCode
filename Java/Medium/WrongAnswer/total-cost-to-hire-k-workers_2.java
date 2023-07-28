class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        long[][] dp = new long[k][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[i];
        }
        for (int i = 1; i < k; i++) {
            int minIndex = i - 1;
            for (int j = i; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] + costs[j];
                if (j - candidates >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - candidates] + costs[j]);
                }
                if (minIndex >= 0 && dp[i][j] > dp[i][minIndex]) {
                    dp[i][j] = dp[i][minIndex];
                }
                minIndex = dp[i][j] < dp[i][minIndex] ? j : minIndex;
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = k - 1; i < n; i++) {
            res = Math.min(res, dp[k - 1][i]);
        }
        return res;
    }
}