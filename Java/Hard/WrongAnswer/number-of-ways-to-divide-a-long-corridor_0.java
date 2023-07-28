class Solution {
    public int numberOfWays(String corridor) {
        
        int mod = 1000000007;
        int n = corridor.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'P') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = (dp[i - 1] + (i > 1 ? dp[i - 2] : 1)) % mod;
            }
        }
        return dp[n - 1];
    }
}