class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int[][] f = new int[n + 1][n + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j + 1] = grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i + 1][j] += Math.min(f[i][j], Math.min(f[i][j - 1], f[i][j + 1]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            ans = Math.min(ans, f[n][j]);
        }
        return ans;
    }
}