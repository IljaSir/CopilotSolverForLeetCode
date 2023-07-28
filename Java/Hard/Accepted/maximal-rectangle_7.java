class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') continue;
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    max = Math.max(max, width * (i - k + 1));
                }
            }
        }
        return max;
    }
}