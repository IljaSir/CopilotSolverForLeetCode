class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        int[][] dp = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 2; k < j + n - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], slices[j] + dp[i - 1][k % n]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[m][i]);
        }
        return ans;
    }
}