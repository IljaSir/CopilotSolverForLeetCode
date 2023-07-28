class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0];
        int col = destination[1];
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= row; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
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
                if (k <= dp[row - 1][col]) {
                    sb.append('V');
                    row--;
                } else {
                    sb.append('H');
                    k -= dp[row - 1][col];
                    col--;
                }
            }
        }
        return sb.toString();
    }
}