class Solution {
    public int countSquares(int[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
            res += dp[i][0];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
            res += dp[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}