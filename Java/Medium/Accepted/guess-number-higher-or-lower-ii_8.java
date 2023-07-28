class Solution {
    public int getMoneyAmount(int n) {
        
        // dp[i][j] means the minimum money we need to guarantee a win in range [i, j]
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i > 0; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        int cost = k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0, k + 1 <= j ? dp[k + 1][j] : 0);
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }
        }
        return dp[1][n];
    }
}