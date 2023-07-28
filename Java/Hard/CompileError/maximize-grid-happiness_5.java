class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int[][][] dp = new int[m][n][1 << n];
        int[][] neighbors = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        int[][][] happiness = new int[m][n][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < (1 << n); k++) {
                    int cur = 0;
                    for (int l = 0; l < neighbors.length; l++) {
                        int x = i + neighbors[l][0];
                        int y = j + neighbors[l][1];
                        if (x >= 0 && y >= 0 && x < m && y < n && (k & (1 << y)) > 0) {
                            cur += 20;
                        }
                    }
                    happiness[i][j][k] = cur;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < (1 << n); k++) {
                    if ((k & (1 << j)) > 0) {
                        int cur = 120;
                        if (introvertsCount > 0) {
                            cur -= happiness[i][j][k];
                            if (i > 0) {
                                cur += dp[i - 1][j][k ^ (1 << j)];
                            }
                            if (j > 0) {
                                cur += dp[i][j - 1][k ^ (1 << j)];
                            }
                        }
                        dp[i][j][k] = cur;
                    } else {
                        int cur = 40;
                        if (extrovertsCount > 0) {
                            cur += happiness[i][j][k];
                            if (i > 0) {
                                cur += dp[i - 1][j][k ^ (1 << j)];
                            }
                            if (j > 0) {
                                cur += dp[i][j - 1][k ^ (1 << j)];
                            }
                        }
                        dp[i][j
    }
}