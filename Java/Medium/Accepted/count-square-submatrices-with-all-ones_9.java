class Solution {
    public int countSquares(int[][] matrix) {
        
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int ans = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
}