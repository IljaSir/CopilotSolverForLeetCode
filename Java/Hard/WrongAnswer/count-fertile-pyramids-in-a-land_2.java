class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int h = dp[i][j];
                    int l = j;
                    int r = j;
                    while (l > 0 && grid[i][l - 1] == 1 && dp[i][l - 1] >= h) {
                        l--;
                    }
                    while (r < n - 1 && grid[i][r + 1] == 1 && dp[i][r + 1] >= h) {
                        r++;
                    }
                    ans += (r - l + 1) * h;
                }
            }
        }
        return ans;
    }
}