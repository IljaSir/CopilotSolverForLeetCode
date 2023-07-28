class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        
        int M = 1000000007;
        int[][] dp = new int[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (int) ((dp[i - 1][j - 1] * (long) (n - j + 1) + dp[i - 1][j] * (long) Math.max(j - k, 0)) % M);
            }
        }
        return dp[goal][n];
    }
}