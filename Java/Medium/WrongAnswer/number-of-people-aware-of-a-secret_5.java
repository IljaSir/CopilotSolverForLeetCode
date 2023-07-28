class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int mod = (int)1e9 + 7;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i <= delay) {
                dp[i] = (dp[i - 1] + 1) % mod;
            } else {
                dp[i] = (dp[i - 1] + dp[i - delay] - (i - forget - 1 >= 0 ? dp[i - forget - 1] : 0) + mod) % mod;
            }
        }
        return dp[n];
    }
}