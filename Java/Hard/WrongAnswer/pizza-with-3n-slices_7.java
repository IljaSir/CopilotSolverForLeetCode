class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int[][] dp = new int[n][n / 3 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n / 3; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = slices[i];
                } else if (i == 1) {
                    dp[i][j] = Math.max(slices[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 2][j - 1] + slices[i], dp[i - 1][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][n / 3]);
        }
        return max;
    }
}