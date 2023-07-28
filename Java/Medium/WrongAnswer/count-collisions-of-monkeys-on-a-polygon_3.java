class Solution {
    public int monkeyMove(int n) {
        
        if (n == 3) {
            return 6;
        }
        if (n == 4) {
            return 14;
        }
        long[] dp = new long[n + 1];
        dp[3] = 6;
        dp[4] = 14;
        for (int i = 5; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }
}