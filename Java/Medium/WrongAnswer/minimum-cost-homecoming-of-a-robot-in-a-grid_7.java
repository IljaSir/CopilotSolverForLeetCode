class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        
        int row = rowCosts.length;
        int col = colCosts.length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + colCosts[j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + rowCosts[i];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}