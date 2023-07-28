class Solution {
public:
    double soupServings(int n) {
        
        if (n > 4800) {
            return 1.0;
        }
        vector<vector<double>> dp(200, vector<double>(200, 0));
        dp[0][0] = 0.5;
        for (int i = 0; i < 200; ++i) {
            for (int j = 0; j < 200; ++j) {
                int a = i + 100;
                int b = j + 100;
                if (a >= 200) {
                    a = 199;
                }
                if (b >= 200) {
                    b = 199;
                }
                dp[a][j] += 0.25 * dp[i][j];
                dp[i][b] += 0.25 * dp[i][j];
                dp[min(a + 25, 199)][min(j + 75, 199)] += 0.25 * dp[i][j];
                dp[min(a + 50, 199)][min(j + 50, 199)] += 0.25 * dp[i][j];
            }
        }
        return dp[(n + 24) / 25][(n + 24) / 25];
    }
};