class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + stoneValue[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k < j; k++) {
                    int left = p[k + 1] - p[i];
                    int right = p[j + 1] - p[k + 1];
                    if (left < right) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k], dp[k + 1][j]) + left);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}