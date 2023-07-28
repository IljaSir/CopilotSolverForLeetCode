class Solution {
    public double soupServings(int n) {
        
        if (n >= 4800)
            return 1;
        double[][] dp = new double[200][200];
        dp[0][0] = 0.5;
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                double p = 0.25;
                if (i == 0)
                    p = 0.5;
                if (i == 0 && j == 0)
                    p = 0.25;
                dp[i][j] += p * (i >= 100 ? dp[i - 100][j] : 1);
                dp[i][j] += p * (i >= 75 && j >= 25 ? dp[i - 75][j - 25] : 1);
                dp[i][j] += p * (i >= 50 && j >= 50 ? dp[i - 50][j - 50] : 1);
                dp[i][j] += p * (i >= 25 && j >= 75 ? dp[i - 25][j - 75] : 1);
            }
        }
        return dp[(n + 24) / 25][(n + 24) / 25];
    }
}