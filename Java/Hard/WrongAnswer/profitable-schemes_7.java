class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        int res = 0, mod = (int)1e9 + 7;
        for (int i = 0; i < group.length; ++i) {
            int g = group[i], p = profit[i];
            for (int j = n; j >= g; --j) {
                for (int k = minProfit; k >= 0; --k) {
                    dp[j][k] = (dp[j][k] + dp[j - g][Math.max(0, k - p)]) % mod;
                }
            }
        }
        for (int x : dp[n]) res = (res + x) % mod;
        return res;
    }
}