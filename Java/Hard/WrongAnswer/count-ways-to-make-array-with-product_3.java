class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int mod = 1000000007;
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int j = 1; j <= n; j++) {
                for (int m = 1; m * j <= n; m++) {
                    dp[m * j] = (dp[m * j] + dp[j]) % mod;
                }
            }
            ret[i] = (int) (((long) dp[n] * k) % mod);
        }
        return ret;
    }
}