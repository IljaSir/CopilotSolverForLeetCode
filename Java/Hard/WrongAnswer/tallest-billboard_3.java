class Solution {
    public int tallestBillboard(int[] rods) {
        
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int target = sum / 2;
        int[][] dp = new int[rods.length + 1][target + 1];
        for (int i = 1; i <= rods.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= rods[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rods[i - 1]] + rods[i - 1]);
                }
            }
        }
        return dp[rods.length][target];
    }
}