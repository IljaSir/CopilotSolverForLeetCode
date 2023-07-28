class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] sum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n];
        return stoneGameII(piles, sum, 0, 1, dp);
    }

    private int stoneGameII(int[] piles, int[] sum, int i, int M, int[][] dp) {
        if (i + 2 * M >= piles.length) {
            return sum[i];
        }
        if (dp[i][M] != 0) {
            return dp[i][M];
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            min = Math.min(min, stoneGameII(piles, sum, i + x, Math.max(M, x), dp));
        }
        dp[i][M] = sum[i] - min;
        return dp[i][M];
    }
}