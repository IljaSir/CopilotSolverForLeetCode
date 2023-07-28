class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0], col = destination[1];
        int[][] dp = new int[row + col + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= row + col; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i && j <= col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (row > 0 && col > 0) {
            if (dp[row + col - 1][col] >= k) {
                sb.append('H');
                col--;
            } else {
                sb.append('V');
                k -= dp[row + col - 1][col];
                row--;
            }
        }
        while (row > 0) {
            sb.append('V');
            row--;
        }
        while (col > 0) {
            sb.append('H');
            col--;
        }
        return sb.toString();
    }
}