class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int j = i - delay;
            if (j < 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] * 2 - dp[j];
                if (j - forget >= 0) {
                    dp[i] -= dp[j - forget];
                }
                dp[i] = (dp[i] + 1000000007) % 1000000007;
            }
        }
        return dp[n - 1];
    }
}