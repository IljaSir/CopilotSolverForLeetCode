class Solution {
    public int cherryPickup(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, Integer.MIN_VALUE);
        dp[0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
            int[][] temp = new int[n][n];
            for (int[] t : temp) Arrays.fill(t, Integer.MIN_VALUE);
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (grid[i][j] == -1 || grid[i][k] == -1) continue;
                    int val = grid[i][j];
                    if (j != k) val += grid[i][k];
                    for (int p = j - 1; p <= j + 1; p++) {
                        for (int q = k - 1; q <= k + 1; q++) {
                            if (p >= 0 && p < n && q >= 0 && q < n) {
                                temp[j][k] = Math.max(temp[j][k], dp[p][q] + val);
                            }
                        }
                    }
                }
            }
            dp = temp;
        }
        int res = 0;
        for (int[] d : dp) res = Math.max(res, Arrays.stream(d).max().getAsInt());
        return res;
    }
}