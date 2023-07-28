class Solution {
    public int countHousePlacements(int n) {
        
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 4;
        for(int i = 2; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % 1000000007 + (dp[i - 2]) % 1000000007;
            dp[i] %= 1000000007;
        }
        return (int)dp[n];
    }
}