class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        int n = questions.size();
        vector<vector<long long>> dp(n, vector<long long>(n, 0));
        dp[0][0] = 0;
        dp[0][1] = questions[0][0];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i + 1; ++j) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] + questions[i][0]);
                    if (j > questions[i][1]) {
                        dp[i][j] = max(dp[i][j], dp[i - 1][j - questions[i][1] - 1]);
                    }
                }
            }
        }
        long long res = 0;
        for (int i = 0; i <= n; ++i) {
            res = max(res, dp[n - 1][i]);
        }
        return res;
    }
};