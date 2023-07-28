class Solution {
    public int rearrangeSticks(int n, int k) {
        
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i > j) {
                    dp[i][j] = (int) ((dp[i-1][j-1] + (long)dp[i-1][j] * (i-1)) % 1000000007);
                }
            }
        }
        return dp[n][k];
    }
}