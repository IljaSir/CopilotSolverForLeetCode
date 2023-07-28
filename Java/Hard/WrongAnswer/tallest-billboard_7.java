class Solution {
    public int tallestBillboard(int[] rods) {
        
        int n = rods.length;
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int m = sum / 2;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int x = rods[i - 1];
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= x) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + x);
                }
                if (j + x <= m) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + x]);
                }
            }
        }
        return dp[n][0];
    }
}