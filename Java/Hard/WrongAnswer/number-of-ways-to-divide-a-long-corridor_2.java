class Solution {
    public int numberOfWays(String corridor) {
        
        int n = corridor.length();
        int m = 1000000007;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                dp[i][0] = dp[i - 1][0] * 2 % m;
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1] * 2 % m;
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return dp[n - 1][1];
    }
}