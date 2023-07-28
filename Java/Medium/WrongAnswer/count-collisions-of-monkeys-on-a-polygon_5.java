class Solution {
    public int monkeyMove(int n) {
        
        long[] dp = new long[n + 1];
        dp[3] = 6;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + (i - 2) * (i - 1)) % mod;
        }
        return (int)dp[n];
    }
}