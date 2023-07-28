class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        return Math.max(
            maxSum(slices, 0, n - 2, m),
            maxSum(slices, 1, n - 1, m)
        );
    }
    
    private int maxSum(int[] slices, int start, int end, int m) {
        int n = end - start + 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], slices[start + j - 1] + dp[i - 1][j - 2]);
            }
        }
        return dp[m][n];
    }
}