class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][1 << n];
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 1) {
                dp[0][1 << j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    for (int k = 0; k < (1 << n); k++) {
                        if ((k & (1 << j)) != 0) {
                            dp[i][k] = dp[i - 1][k];
                        } else {
                            dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k | (1 << j)] + 1);
                        }
                    }
                } else {
                    for (int k = 0; k < (1 << n); k++) {
                        dp[i][k] = dp[i - 1][k];
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == numSelect) {
                res = Math.max(res, dp[m - 1][i]);
            }
        }
        return res;
    }
}