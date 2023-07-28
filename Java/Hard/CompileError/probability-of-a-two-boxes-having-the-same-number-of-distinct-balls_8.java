class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int m = balls.length / 2;
        int sum = 0;
        for (int x : balls) {
            sum += x;
        }
        long[] f = new long[sum + 1];
        f[0] = 1;
        for (int i = 1; i <= sum; i++) {
            f[i] = f[i - 1] * i;
        }
        long[][] c = new long[sum + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0 || j == i) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                }
            }
        }
        int[] cnt = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    cnt[i] += balls[j];
                }
            }
        }
        long[][][] dp = new long[m + 1][m + 1][1 << n];
        dp[0][0][0] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < (1 << n); k++) {
                    if (dp[i][j][k] == 0) {
                        continue;
                    }
                    for (int p = 0; p < n; p++) {
                        if ((k & (1 << p)) != 0) {
                            continue;
                        }
                        if (balls[p] > 0) {
                            if (i < m) {
                                dp[i + 1][j][k | (1 << p)] += dp[i][j][k] * c[cnt[k]][balls[p]] * c[sum - cnt[k]][balls[p] - 1];
                            }
                            if (j < m) {
    }
}