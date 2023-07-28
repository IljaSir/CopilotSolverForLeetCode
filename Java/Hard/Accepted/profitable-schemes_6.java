class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int MOD = 1_000_000_007;
        int[][] dp = new int[minProfit + 1][n + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; ++k) {
            int g = group[k], p = profit[k];
            for (int i = minProfit; i >= 0; --i)
                for (int j = n - g; j >= 0; --j)
                    dp[Math.min(i + p, minProfit)][j + g] = (dp[Math.min(i + p, minProfit)][j + g] + dp[i][j]) % MOD;
        }

        int ans = 0;
        for (int x: dp[minProfit]) ans = (ans + x) % MOD;
        return ans;
    }
}