class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j][0] = (i > 0 && j > 0 ? dp[i - 1][j - 1][0] : 0) + 1;
                    dp[i][j][1] = (i > 0 && j < n - 1 ? dp[i - 1][j + 1][1] : 0) + 1;
                    int min = Math.min(dp[i][j][0], dp[i][j][1]);
                    for (int k = 1; k <= min; k++) {
                        if (dp[i - k + 1][j - (i - k + 1)][0] >= k && dp[i - k + 1][j + (i - k + 1)][1] >= k) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}