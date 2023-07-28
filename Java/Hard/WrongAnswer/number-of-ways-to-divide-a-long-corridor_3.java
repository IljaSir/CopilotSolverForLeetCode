class Solution {
    public int numberOfWays(String corridor) {
        
        int n = corridor.length();
        int mod = 1000000007;
        int[] dp = new int[n];
        int[] sum = new int[n];
        dp[0] = 1;
        sum[0] = 1;
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'P') {
                dp[i] = 0;
            } else {
                dp[i] = sum[i - 1];
            }
            sum[i] = (sum[i - 1] + dp[i]) % mod;
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (corridor.charAt(i) == 'P') {
                break;
            }
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}