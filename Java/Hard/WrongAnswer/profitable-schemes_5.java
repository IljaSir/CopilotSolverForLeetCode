class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int mod = 1000000007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int members = group[k], earn = profit[k];
            for (int i = n; i >= members; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - members][Math.max(0, j - earn)]) % mod;
                }
            }
        }
        int res = 0;
        for (int x : dp[n]) res = (res + x) % mod;
        return res;
    }
}