class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] prefix = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + stoneValue[i-1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = 0;
                for (int k = i; k < j; k++) {
                    int left = prefix[k+1] - prefix[i];
                    int right = prefix[j+1] - prefix[k+1];
                    if (left < right) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = Math.max(dp[i][j], dp[k+1][j] + right);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k], dp[k+1][j]) + left);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}