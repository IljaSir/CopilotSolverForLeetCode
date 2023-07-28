class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int mod = 1000000007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            for (int i = n; i >= g; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[i][minProfit]) % mod;
        }
        return res;
    }
}