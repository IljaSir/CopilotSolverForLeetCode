class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        int[][] dp = new int[m + 1][n + 1];
        for (int[] p : prices) {
            for (int i = m; i >= p[0]; i--) {
                for (int j = n; j >= p[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - p[0]][j - p[1]] + p[2]);
                }
            }
        }
        return dp[m][n];
    }
}