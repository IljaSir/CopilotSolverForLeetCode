class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + piles[i];
        }
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 1, preSum, dp);
    }

    private int dfs(int i, int M, int[] preSum, int[][] dp) {
        if (i == preSum.length - 1) {
            return 0;
        }
        if (2 * M >= preSum.length - i - 1) {
            return preSum[preSum.length - 1] - preSum[i];
        }
        if (dp[i][M] != -1) {
            return dp[i][M];
        }
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, preSum[i + x] - preSum[i] + preSum[preSum.length - 1] - preSum[i + x] - dfs(i + x, Math.max(M, x), preSum, dp));
        }
        dp[i][M] = res;
        return res;
    }
}