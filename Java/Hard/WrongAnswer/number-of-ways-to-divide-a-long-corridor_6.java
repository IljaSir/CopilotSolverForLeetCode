class Solution {
    public int numberOfWays(String corridor) {
        
        int n = corridor.length();
        int[] dp = new int[n];
        int[] sum = new int[n];
        int mod = 1000000007;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'P') {
                continue;
            }
            if (i == 0) {
                dp[i] = 1;
            } else {
                dp[i] = sum[i - 1];
            }
            sum[i] = (sum[i] + dp[i]) % mod;
            if (i > 0) {
                sum[i] = (sum[i] + sum[i - 1]) % mod;
            }
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}