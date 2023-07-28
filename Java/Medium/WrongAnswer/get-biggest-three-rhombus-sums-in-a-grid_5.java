class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = grid[i][j];
                dp[i][j][1] = grid[i][j];
                if (i > 0) {
                    dp[i][j][0] += dp[i - 1][j][0];
                }
                if (j > 0) {
                    dp[i][j][1] += dp[i][j - 1][1];
                }
                if (i > 0 && j > 0) {
                    dp[i][j][0] -= dp[i - 1][j - 1][0];
                    dp[i][j][1] -= dp[i - 1][j - 1][1];
                }
            }
        }
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 1; i + l < m && j + l < n; l++) {
                        int sum = dp[i + l][j + l][k] - dp[i][j][k];
                        if (k == 0) {
                            sum -= dp[i + l][j][1] - dp[i][j][1];
                        } else {
                            sum -= dp[i][j + l][0] - dp[i][j][0];
                        }
                        set.add(sum);
                        if (set.size() > 3) {
                            set.remove(set.iterator().next());
                        }
                    }
                }
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
}