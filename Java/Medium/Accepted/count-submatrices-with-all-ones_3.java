class Solution {
    public int numSubmat(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + (j > 0 ? dp[i][j - 1] : 0);
                }
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    ans += width;
                }
            }
        }
        return ans;
    }
}