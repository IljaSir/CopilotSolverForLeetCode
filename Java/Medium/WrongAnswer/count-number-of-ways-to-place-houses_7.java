class Solution {
    public int countHousePlacements(int n) {
        
        long dp[][] = new long[n+1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i = 1; i <= n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000007;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][1]) % 1000000007;
        }
        return (int)((dp[n][0] + dp[n][1]) % 1000000007);
    }
}