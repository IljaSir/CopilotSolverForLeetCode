class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        itmx = 0;
        for (int i = 1; i <= m; i++) {
            for (it j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
                if (i >= max + 1 && j >= max + 1 && dp[i][j] - dp[i - max - 1][j] - dp[i][j - max - 1] + dp[i - max - 1][j - max - 1] <= threhold) {
                    max++;
                }
            }
        }
        return max
    }
}