class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0 ? 0 : dp[i][j - 1]) + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int width = j - i + 1;
                int height = 0;
                for (int k = 0; k < n; k++) {
                    if (dp[k][j] >= width) {
                        height++;
                    } else {
                        height = 0;
                    }
                    result = Math.max(result, width * height);
                }
            }
        }
        return result;
    }
}