class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            a[i] = slices[i];
            b[i] = slices[i + 1];
        }
        return Math.max(solve(a, m), solve(b, m));
    }
    
    public int solve(int[] a, int m) {
        int n = a.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + a[i - 1]);
            }
        }
        return dp[n][m];
    }
}