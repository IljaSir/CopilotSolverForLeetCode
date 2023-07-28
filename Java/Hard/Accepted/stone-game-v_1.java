class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + stoneValue[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int k = j + i;
                dp[j][k] = 0;
                for (int m = j; m < k; m++) {
                    int left = sum[m + 1] - sum[j];
                    int right = sum[k + 1] - sum[m + 1];
                    if (left < right) {
                        dp[j][k] = Math.max(dp[j][k], dp[j][m] + left);
                    } else if (left > right) {
                        dp[j][k] = Math.max(dp[j][k], dp[m + 1][k] + right);
                    } else {
                        dp[j][k] = Math.max(dp[j][k], dp[j][m] + left);
                        dp[j][k] = Math.max(dp[j][k], dp[m + 1][k] + right);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}