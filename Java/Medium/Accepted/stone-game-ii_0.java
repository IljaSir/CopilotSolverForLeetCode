class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] sum = new int[n];
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 1, dp, sum);
    }

    private int dfs(int i, int m, int[][] dp, int[] sum) {
        if (i == dp.length) {
            return 0;
        }
        if (2 * m >= dp.length - i) {
            return sum[i];
        }
        if (dp[i][m] != -1) {
            return dp[i][m];
        }
        int res = 0;
        for (int x = 1; x <= 2 * m; x++) {
            res = Math.max(res, sum[i] - dfs(i + x, Math.max(m, x), dp, sum));
        }
        dp[i][m] = res;
        return res;
    }
}