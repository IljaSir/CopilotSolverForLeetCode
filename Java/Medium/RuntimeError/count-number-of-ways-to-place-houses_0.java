class Solution {
    public int countHousePlacements(int n) {
        
        long[] dp = new long[n + 1];
        dp[1] = 4;
        dp[2] = 9;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }
        return (int) (dp[n] % (Math.pow(10, 9) + 7));
    }
}