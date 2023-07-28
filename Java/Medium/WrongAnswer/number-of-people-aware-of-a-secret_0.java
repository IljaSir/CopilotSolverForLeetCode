class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - delay];
            if (i > forget) {
                dp[i] -= dp[i - forget - 1];
            }
            dp[i] = (dp[i] + 1000000007) % 1000000007;
        }
        return dp[n];
    }
}