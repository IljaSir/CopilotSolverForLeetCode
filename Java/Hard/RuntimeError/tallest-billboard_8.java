class Solution {
    public int tallestBillboard(int[] rods) {
        
        int N = rods.length;
        int[][] dp = new int[N + 1][5001];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][2500] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 5000; j++) {
                if (dp[i][j] >= 0) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    dp[i + 1][j + rods[i]] = Math.max(dp[i + 1][j + rods[i]], dp[i][j]);
                    dp[i + 1][Math.abs(j - rods[i])] = Math.max(dp[i + 1][Math.abs(j - rods[i])], dp[i][j] + Math.min(j, rods[i]));
                }
            }
        }
        return dp[N][2500];
    }
}