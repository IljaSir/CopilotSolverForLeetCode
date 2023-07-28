class Solution {
    public int monkeyMove(int n) {
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * (i - 1) + dp[i - 2] * (i - 1)) % 1000000007;
        }
        return (int) dp[n];
    }
}