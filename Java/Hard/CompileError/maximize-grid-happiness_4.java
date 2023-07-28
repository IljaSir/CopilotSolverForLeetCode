class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int[][][] dp = new int[m][n][1 << n];
        int max = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (Integer.bitCount(i) == introvertsCount) {
                dp[0][0][i] = happiness(i, 0, n);
                max = Math.max(max, dp[0][0][i]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                for (int k = 0; k < 1 << n; k++) {
                    if (Integer.bitCount(k) != extrovertsCount) {
                        continue;
                    }
                    for (int l = 0; l < 1 << n; l++) {
                        if (Integer.bitCount(l) != introvertsCount) {
                            continue;
                        }
                        if (i > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][n - 1][l] + happiness(k, l, n));
                        } else {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][l] + happiness(k, l, n));
                        }
                    }
                    if (i == m - 1 && j == n - 1) {
                        max = Math.max(max, dp[i][j][k]);
                    }
                }
            }
        }
        return max;
    }

    private int happiness(int extroverts, int introverts, int n) {
        int h = 0;
        for (int i = 0; i < n; i++) {
            if ((extroverts & (1 << i)) > 0) {
                h += 40;
                if (i > 0 && (extroverts & (1 << (i - 1))) > 0) {
                    h += 20;
                }
                if (i < n - 1 && (extroverts & (1 << (i + 1))) > 0) {
                    h += 20;
                }
                if (i >
    }
}