class Solution {
    public int twoEggDrop(int n) {
        
        int egg = 2;
        int[][] dp = new int[egg + 1][n + 1];
        for (int i = 1; i <= egg; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= j; k++) {
                        int res = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                        dp[i][j] = Math.min(dp[i][j], res);
                    }
                }
            }
        }
        return dp[egg][n];
    }
}