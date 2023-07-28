class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i - delay - forget >= 0) {
                dp[i] = (dp[i] + dp[i - delay - forget]) % 1000000007;
            } else {
                dp[i] = (dp[i] + 1) % 1000000007;
            }
        }
        return dp[n];
    }
}