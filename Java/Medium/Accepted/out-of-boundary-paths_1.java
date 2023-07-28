class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int result = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < maxMove; i++) {
            int[][] dp2 = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int count = dp[r][c];
                    if (count > 0) {
                        for (int[] dir : directions) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                result = (result + count) % MOD;
                            } else {
                                dp2[nr][nc] = (dp2[nr][nc] + count) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        return result;
    }
}