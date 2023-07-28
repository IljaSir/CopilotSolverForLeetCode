class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] prefix = new int[n];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int sum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                for (int k = i; k < j; k++) {
                    int left = prefix[k] - (i > 0 ? prefix[i - 1] : 0);
                    int right = sum - left;
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