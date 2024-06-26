class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                dp[j][j + i] = Math.max(piles[j] - dp[j + 1][j + i], piles[j + i] - dp[j][j + i - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}