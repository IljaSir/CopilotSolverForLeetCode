class Solution {
    public int tallestBillboard(int[] rods) {
        
        int n = rods.length;
        int[][] dp = new int[n + 1][5001];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 5000; j++) {
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j >= rods[i - 1] && dp[i - 1][j - rods[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rods[i - 1]] + rods[i - 1]);
                }
                if (j + rods[i - 1] <= 5000 && dp[i - 1][j + rods[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]]);
                }
            }
        }
        return dp[n][0];
    }
}