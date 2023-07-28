class Solution {
    public double soupServings(int n) {
        
        if (n > 4800) {
            return 1.0;
        }

        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];
        dp[0][0] = 0.5;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                int sum = i + j;
                if (sum == 0) {
                    continue;
                }

                double p = 0.25;
                if (i >= 4) {
                    dp[i][j] += p * dp[i - 4][j];
                } else {
                    dp[i][j] += p * 0.5;
                }

                if (i >= 3 && j >= 1) {
                    dp[i][j] += p * dp[i - 3][j - 1];
                } else if (i >= 3) {
                    dp[i][j] += p * 0.5;
                } else if (j >= 1) {
                    dp[i][j] += p * 0.5;
                }

                if (i >= 2 && j >= 2) {
                    dp[i][j] += p * dp[i - 2][j - 2];
                } else if (i >= 2) {
                    dp[i][j] += p * 0.5;
                } else if (j >= 2) {
                    dp[i][j] += p * 0.5;
                }

                if (i >= 1 && j >= 3) {
                    dp[i][j] += p * dp[i - 1][j - 3];
                } else if (i >= 1) {
                    dp[i][j] += p * 0.5;
                } else if (j >= 3) {
                    dp[i][j] += p * 0.5;
                }
            }
        }

        return dp[N][N];
    }
}