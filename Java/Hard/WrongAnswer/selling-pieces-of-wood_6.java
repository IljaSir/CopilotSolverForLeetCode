class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        int[] dp = new int[m * n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int[] price : prices) {
            int h = price[0], w = price[1], p = price[2];
            for (int i = h; i <= m; i++) {
                for (int j = w; j <= n; j++) {
                    dp[i * j] = Math.max(dp[i * j], dp[i * j - h * w] + p);
                }
            }
        }
        return dp[m * n];
    }
}