class Solution {
public:
    double soupServings(int n) {
        
        if (n > 4800) {
            return 1.0;
        }
        vector<vector<double>> dp(200, vector<double>(200));
        dp[0][0] = 0.5;
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                int a = i + 100;
                int b = j + 100;
                if (a >= 200 || b >= 200) {
                    continue;
                }
                dp[a][b] += dp[i][j] * 0.25;
                dp[a][j] += dp[i][j] * 0.25;
                dp[i][b] += dp[i][j] * 0.25;
                dp[min(a + b, 199)][min(a + b, 199)] += dp[i][j] * 0.25;
            }
        }
        double ans = 0;
        for (int i = n / 25; i < 200; i++) {
            ans += dp[i][n / 25];
        }
        return ans;
    }
};