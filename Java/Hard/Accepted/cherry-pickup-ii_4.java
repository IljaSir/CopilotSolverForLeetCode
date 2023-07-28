class Solution {
    public int cherryPickup(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        for (int i = m - 1; i >= 0; i--) {
            int[][] dp2 = new int[n][n];
            for (int p1 = 0; p1 < n; p1++) {
                for (int p2 = 0; p2 < n; p2++) {
                    int max = 0;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int n1 = p1 + d1, n2 = p2 + d2;
                            if (n1 >= 0 && n1 < n && n2 >= 0 && n2 < n) {
                                max = Math.max(max, dp[n1][n2]);
                            }
                        }
                    }
                    dp2[p1][p2] = max + grid[i][p1] + (p1 == p2 ? 0 : grid[i][p2]);
                }
            }
            dp = dp2;
        }
        return dp[0][n - 1];
    }
}