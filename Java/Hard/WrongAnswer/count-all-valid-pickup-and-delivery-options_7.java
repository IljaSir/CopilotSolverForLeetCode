class Solution {
    public int countOrders(int n) {
        
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] * (2*i-1) * (2*i)) % mod;
        }
        return (int) dp[n];
    }
}