class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + stoneValue[i - 1];
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                dp[i][j] = 0;
                for (int k = i; k < j; k++) {
                    int left = sum[k + 1] - sum[i];
                    int right = sum[j + 1] - sum[k + 1];
                    if (left >= right) {
                        dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + right);
                    }
                    if (left <= right) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + left);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}