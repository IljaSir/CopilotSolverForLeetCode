class Solution {
    public int countPaths(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int mod = (int)1e9 + 7;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j]) {
                        dp[i][j] = (dp[i][j] + dp[x][y]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + dp[i][j]) % mod;
            }
        }
        return res;
    }
}