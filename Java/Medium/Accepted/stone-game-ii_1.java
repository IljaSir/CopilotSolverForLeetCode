class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] sum = new int[n];
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfs(0, 1, sum, dp);
    }

    private int dfs(int i, int M, int[] sum, int[][] dp) {
        if (i == dp.length) {
            return 0;
        }
        if (2 * M >= dp.length - i) {
            return sum[i];
        }
        if (dp[i][M] != Integer.MIN_VALUE) {
            return dp[i][M];
        }
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, sum[i] - dfs(i + x, Math.max(M, x), sum, dp));
        }
        dp[i][M] = res;
        return res;
    }
}