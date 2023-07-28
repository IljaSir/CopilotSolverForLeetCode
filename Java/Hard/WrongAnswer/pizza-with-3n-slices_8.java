class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] s = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                s[j] = slices[(i + j + 1) % n];
            }
            max = Math.max(max, max(s));
        }
        return max;
    }

    private int max(int[] slices) {
        int n = slices.length;
        int[][] dp = new int[n + 1][n / 3 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n / 3; j++) {
                if (i == 1) {
                    dp[i][j] = slices[i - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], slices[i - 1] + dp[i - 2][j - 1]);
                }
            }
        }
        return dp[n][n / 3];
    }
}