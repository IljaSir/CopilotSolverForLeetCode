class Solution {
    public int monkeyMove(int n) {
        
        int mod = 1000000007;
        long dp[] = new long[n+1];
        dp[3] = 6;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1]*2 + dp[i-2])%mod;
        }
        return (int)dp[n];
    }
}