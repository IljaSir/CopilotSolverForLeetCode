class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1000000007;
        int[][][] dp = new int[m][n][maxMove + 1];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        for (int i = 0; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == 0) {
                        if (j == startRow && k == startColumn) {
                            dp[j][k][i] = 1;
                        }
                    } else {
                        for (int[] dir : dirs) {
                            int x = j + dir[0];
                            int y = k + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                dp[j][k][i] += dp[x][y][i - 1];
                                dp[j][k][i] %= MOD;
                            } else {
                                count += dp[j][k][i - 1];
                                count %= MOD;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}