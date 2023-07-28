class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0];
        int col = destination[1];
        int[][] dp = new int[row+1][col+1];
        dp[0][0] = 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i != row || j != col) {
            if (i == row) {
                sb.append("H");
                j++;
            } else if (j == col) {
                sb.append("V");
                i++;
            } else {
                if (dp[i][j+1] >= k) {
                    sb.append("H");
                    j++;
                } else {
                    sb.append("V");
                    k -= dp[i][j+1];
                    i++;
                }
            }
        }
        return sb.toString();
    }
}