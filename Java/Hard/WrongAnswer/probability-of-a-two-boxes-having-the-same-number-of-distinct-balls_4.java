class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int m = 0;
        for (int ball : balls) {
            m += ball;
        }
        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = m; k >= 0; k--) {
                    for (int l = 1; l <= balls[i]; l++) {
                        if (j + l <= m && k + balls[i] - l <= m) {
                            dp[j + l][k + balls[i] - l] += dp[j][k];
                        }
                    }
                }
            }
        }
        int total = 1;
        for (int i = 2; i <= m; i++) {
            total *= i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= balls[i]; j++) {
                total /= j;
            }
        }
        int same = 0;
        for (int i = 0; i <= m / 2; i++) {
            same += dp[i][i];
        }
        return (double) same / total;
    }
}