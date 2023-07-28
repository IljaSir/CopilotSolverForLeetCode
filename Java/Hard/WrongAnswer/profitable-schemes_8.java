class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int[][] dp = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        int m = group.length;
        int mod = 1000000007;
        for (int k = 0; k < m; ++k) {
            int g = group[k], p = profit[k];
            for (int i = n; i >= g; --i) {
                for (int j = minProfit; j >= 0; --j) {
                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)]) % mod;
                }
            }
        }
        int ans = 0;
        for (int x: dp[n]) ans = (ans + x) % mod;
        return ans;
    }
}