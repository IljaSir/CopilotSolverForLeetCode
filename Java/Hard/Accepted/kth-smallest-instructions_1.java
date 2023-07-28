class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0];
        int col = destination[1];
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (row > 0 || col > 0) {
            if (row == 0) {
                sb.append('H');
                col--;
            } else if (col == 0) {
                sb.append('V');
                row--;
            } else {
                if (dp[row][col - 1] >= k) {
                    sb.append('H');
                    col--;
                } else {
                    sb.append('V');
                    k -= dp[row][col - 1];
                    row--;
                }
            }
        }
        return sb.toString();
    }
}