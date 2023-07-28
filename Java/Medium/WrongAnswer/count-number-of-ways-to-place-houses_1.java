class Solution {
    public int countHousePlacements(int n) {
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return (int) ((dp[n] + dp[n - 1]) % (Math.pow(10, 9) + 7));
    }
}