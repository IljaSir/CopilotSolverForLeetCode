class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] sum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n];
        return dfs(piles, 0, 1, sum, dp);
    }
    private int dfs(int[] piles, int i, int M, int[] sum, int[][] dp) {
        if (i == piles.length) return 0;
        if (2 * M >= piles.length - i) return sum[i];
        if (dp[i][M] != 0) return dp[i][M];
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, sum[i] - dfs(piles, i + x, Math.max(x, M), sum, dp));
        }
        dp[i][M] = res;
        return res;
    }
}