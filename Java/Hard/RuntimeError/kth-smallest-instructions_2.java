class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0], col = destination[1];
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i == 0 && j == 0) continue;
                dp[i][j] = i > 0 ? dp[i - 1][j] : 0;
                dp[i][j] += j > 0 ? dp[i][j - 1] : 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (row > 0 || col > 0) {
            if (row > 0 && k > dp[row - 1][col]) {
                k -= dp[row - 1][col];
                row--;
                sb.append('V');
            } else {
                col--;
                sb.append('H');
            }
        }
        return sb.toString();
    }
}