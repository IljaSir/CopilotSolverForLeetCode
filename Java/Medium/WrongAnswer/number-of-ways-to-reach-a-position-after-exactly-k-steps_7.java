class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        
        int mod = (int) 1e9 + 7;
        int n = 1001;
        int[][] dp = new int[2][n];
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; i++) {
            int cur = i % 2;
            int pre = (i - 1) % 2;
            int[] sum = new int[n];
            sum[0] = dp[pre][0];
            for (int j = 1; j < n; j++) {
                sum[j] = (sum[j - 1] + dp[pre][j]) % mod;
            }
            for (int j = 0; j < n; j++) {
                dp[cur][j] = sum[j];
                if (j > 0) {
                    dp[cur][j] -= dp[pre][j - 1];
                    dp[cur][j] = (dp[cur][j] + mod) % mod;
                }
            }
        }
        return dp[k % 2][endPos];
    }
}