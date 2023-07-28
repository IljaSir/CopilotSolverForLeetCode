class Solution {
    public int tallestBillboard(int[] rods) {
        
        int n = rods.length;
        int[][] dp = new int[n + 1][5001];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 5000; j++) {
                if (dp[i][j] >= 0) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    dp[i + 1][j + rods[i]] = Math.max(dp[i + 1][j + rods[i]], dp[i][j] + rods[i]);
                    dp[i + 1][Math.abs(j - rods[i])] = Math.max(dp[i + 1][Math.abs(j - rods[i])], dp[i][j]);
                }
            }
        }
        return dp[n][0];
    }
}