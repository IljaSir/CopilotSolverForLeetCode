class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= group.length; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= group.length; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= group[i - 1]) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % 1000000007;
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j <= n; j++) {
            res = (res + dp[group.length][j][minProfit]) % 1000000007;
        }
        return res;
    }
}