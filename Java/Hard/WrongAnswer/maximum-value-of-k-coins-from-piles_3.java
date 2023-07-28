class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = piles.get(i).get(j);
                } else {
                    dp[i][j] = dp[i][j - 1] + piles.get(i).get(j);
                }
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Integer.MIN_VALUE;
                    for (int l = 0; l <= j; l++) {
                        if (i == 0) {
                            if (l % 2 == 1) {
                                f[i][j] = Math.max(f[i][j], dp[i][m - 1] - dp[i][l - 1]);
                            }
                        } else {
                            if (l % 2 == 1) {
                                f[i][j] = Math.max(f[i][j], f[i - 1][j - l] + dp[i][m - 1] - dp[i][l - 1]);
                            }
                        }
                    }
                }
            }
        }
        return f[n - 1][k];
    }
}