class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    int h = Math.min(dp[i][j][0], dp[i][j][1]);
                    for (int k = 1; k <= h; k++) {
                        if (dp[i][j - k][1] >= k) {
                            ans++;
                        }
                        if (dp[i - k][j][0] >= k) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}