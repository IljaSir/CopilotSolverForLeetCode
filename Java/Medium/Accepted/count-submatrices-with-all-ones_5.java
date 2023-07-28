class Solution {
    public int numSubmat(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] == 1 ? dp[i][j - 1] + 1 : 0;
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k >= 1; k--) {
                    min = Math.min(min, dp[k][j]);
                    res += min;
                }
            }
        }
        return res;
    }
}