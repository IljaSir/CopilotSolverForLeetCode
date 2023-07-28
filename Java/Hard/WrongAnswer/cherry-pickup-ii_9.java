class Solution {
    public int cherryPickup(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for (int[][] d : dp) {
            for (int[] a : d) {
                Arrays.fill(a, -1);
            }
        }
        dp[0][0][cols - 1] = grid[0][0] + grid[0][cols - 1];
        for (int i = 1; i < rows; i++) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    int[] d = new int[]{-1, 0, 1};
                    for (int k1 : d) {
                        for (int k2 : d) {
                            int j3 = j1 + k1;
                            int j4 = j2 + k2;
                            if (j3 >= 0 && j3 < cols && j4 >= 0 && j4 < cols) {
                                dp[i][j1][j2] = Math.max(dp[i][j1][j2], dp[i - 1][j3][j4] + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]));
                            }
                        }
                    }
                }
            }
        }
        return dp[rows - 1][0][cols - 1];
    }
}