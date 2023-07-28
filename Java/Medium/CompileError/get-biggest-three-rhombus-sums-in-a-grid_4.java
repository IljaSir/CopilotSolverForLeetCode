class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                if (i > 0) {
                    sum += dp[i - 1][j][0];
                }
                if (j > 0) {
                    sum += dp[i][j - 1][1];
                }
                if (i > 0 && j > 0) {
                    sum -= dp[i - 1][j - 1][0];
                }
                dp[i][j][0] = sum;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                if (i < m - 1) {
                    sum += dp[i + 1][j][0];
                }
                if (j > 0) {
                    sum += dp[i][j - 1][1];
                }
                if (i < m - 1 && j > 0) {
                    sum -= dp[i + 1][j - 1][0];
                }
                dp[i][j][1] = sum;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                for (int k = 1; k <= Math.min(i, j); k++) {
                    if (i + k >= m || j + k >= n) {
                        break;
                    }
                    sum += dp[i + k][j + k][1] - dp[i - k][j + k][1] - dp[i + k][j - k][1] + dp[i - k][j - k][1];
                    set.add(sum);
                }
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (int x : set) {
            ans[i++] = x;
        }
        Arrays.sort
    }
}