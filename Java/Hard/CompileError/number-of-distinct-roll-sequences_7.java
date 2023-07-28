class Solution {
    public int distinctSequences(int n) {
        
        int mod = 1000000007;
        long[][] dp = new long[n+1][7];
        for(int i = 1; i <= 6; i++) dp[1][i] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= 6; j++) {
                for(int k = 1; k <= 6; k++) {
                    if(j == k) continue;
                    if(gcd(j, k) > 1) continue;
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }
        long ans = 0;
        for(int i = 1; i <= 6; i++) {
            ans += dp[n][i];
            ans %= mod;
        }
        return (int)ans;
    }
}