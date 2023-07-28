class Solution {
    public int tallestBillboard(int[] rods) {
        
        int n = rods.length;
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - rods[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rods[i - 1]] + rods[i - 1]);
                }
                if (j + rods[i - 1] <= sum) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]]);
                }
            }
        }
        return dp[n][0] / 2;
    }
}