class Solution {
    public int tallestBillboard(int[] rods) {
        
        int n = rods.length;
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            int rod = rods[i - 1];
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= rod) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rod]);
                }
                if (j + rod <= sum) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rod] + rod);
                }
            }
        }
        return dp[n][0] / 2;
    }
}