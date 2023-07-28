class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] dp2 = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    if (j > 0) {
                        dp2[i][j] = dp2[i][j - 1] + 1;
                    } else {
                        dp2[i][j] = 1;
                    }
                    int minHeight = dp[i][j];
                    int minHeight2 = dp2[i][j];
                    for (int k = j; k >= 0; k--) {
                        minHeight = Math.min(minHeight, dp[i][k]);
                        minHeight2 = Math.min(minHeight2, dp2[i][k]);
                        if (minHeight >= 2 && minHeight2 >= 2) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}