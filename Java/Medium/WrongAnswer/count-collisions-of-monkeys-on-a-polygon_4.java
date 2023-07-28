class Solution {
    public int monkeyMove(int n) {
        
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (i + 1) % 1000000007;
        }
        return (int) dp[n - 1];
    }
}