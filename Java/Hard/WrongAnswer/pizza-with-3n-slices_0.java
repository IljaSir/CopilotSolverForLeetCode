class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        return Math.max(maxSizeSlices(slices, 0, n - 2, m), maxSizeSlices(slices, 1, n - 1, m));
    }
    
    int maxSizeSlices(int[] slices, int l, int r, int m) {
        int n = r - l + 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + slices[l + j - 1]);
            }
        }
        return dp[m][n];
    }
}