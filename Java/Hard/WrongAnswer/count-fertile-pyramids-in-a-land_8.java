class Solution {
    public int countPyramids(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = grid[i-1][j-1] + dp[i][j-1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int h = 1;
                while (i+h-1 <= m && j-h >= 0 && j+h-1 < n) {
                    int x = dp[i+h-1][j+h-1] - dp[i+h-1][j-h] - dp[i-1][j+h-1] + dp[i-1][j-h];
                    if (x == h*h) {
                        ans++;
                    }
                    h++;
                }
            }
        }
        return ans;
    }
}