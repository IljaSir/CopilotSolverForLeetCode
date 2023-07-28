class Solution {
    public int monkeyMove(int n) {
        
        long[] dp = new long[3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            long next = (dp[0] + dp[1] + dp[2]) % 1000000007;
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = next;
        }
        return (int) dp[2];
    }
}