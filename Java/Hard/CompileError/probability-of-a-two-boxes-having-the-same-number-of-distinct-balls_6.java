class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int m = balls.length / 2;
        int[] cnt = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cnt[i] += balls[j];
                }
            }
        }
        int[][] dp = new int[1 << n][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < n; k++) {
                    if (((i >> k) & 1) == 0) {
                        dp[i | (1 << k)][j + 1] += dp[i][j];
                    }
                }
            }
        }
        int[] s = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) {
                    s[i | (1 << j)] = s[i] + 1;
                }
            }
        }
        int[] f = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    f[i] = f[i ^ (1 << j)] + balls[j];
                }
            }
        }
        int[] g = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    g[i] = g[i ^ (1 << j)] + 1;
                }
            }
        }
        int[] all = new int[1 << n];
        for (int i = 0; i < (
    }
}