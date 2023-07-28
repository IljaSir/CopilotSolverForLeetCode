class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] dp = new int[n];
        dp[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + piles[i];
        }
        int[][] memo = new int[n][n];
        return dfs(piles, 0, 1, dp, memo);
    }

    private int dfs(int[] piles, int i, int M, int[] dp, int[][] memo) {
        if (i == piles.length) {
            return 0;
        }
        if (2 * M >= piles.length - i) {
            return dp[i];
        }
        if (memo[i][M] > 0) {
            return memo[i][M];
        }
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, dp[i] - dfs(piles, i + x, Math.max(x, M), dp, memo));
        }
        memo[i][M] = res;
        return res;
    }
}