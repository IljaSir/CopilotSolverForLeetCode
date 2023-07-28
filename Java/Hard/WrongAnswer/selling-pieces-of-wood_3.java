class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        int[][] dp = new int[m + 1][n + 1];
        for (int[] p : prices) {
            int h = p[0], w = p[1], price = p[2];
            for (int i = h; i <= m; ++i) {
                for (int j = w; j <= n; ++j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - h][j - w] + price);
                }
            }
        }
        return dp[m][n];
    }
}