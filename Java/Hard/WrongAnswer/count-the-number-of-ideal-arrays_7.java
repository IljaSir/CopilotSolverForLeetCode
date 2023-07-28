class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int mod = 1000000007;
        long[][] dp = new long[maxValue+1][n+1];
        dp[1][1] = 1;
        for (int i=2; i<=maxValue; i++) {
            dp[i][1] = i;
            for (int j=2; j<=n; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }
        long sum = 0;
        for (int i=1; i<=maxValue; i++) {
            sum = (sum + dp[i][n]) % mod;
        }
        return (int)sum;
    }
}