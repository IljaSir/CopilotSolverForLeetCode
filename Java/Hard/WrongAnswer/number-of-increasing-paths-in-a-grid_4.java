class Solution {
    public int countPaths(int[][] grid) {
        
        int MOD = (int)1e9 + 7;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt = 0;
                for (int[] dir: new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] >= grid[i][j]) continue;
                    cnt = (cnt + dp[x][y]) % MOD;
                }
                dp[i][j] = cnt;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = (ans + dp[i][j]) % MOD;
            }
        }
        return ans;
    }
}