class Solution {
    public int monkeyMove(int n) {
        
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int) (2 * (dp[n - 1] + dp[n - 2]) % 1000000007);
    }
}