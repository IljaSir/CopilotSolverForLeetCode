class Solution {
public:
    int minScoreTriangulation(vector<int>& values) {
        
        int n = values.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 2; i < n; ++i) {
            for (int j = 0; j + i < n; ++j) {
                dp[j][j + i] = INT_MAX;
                for (int k = j + 1; k < j + i; ++k) {
                   dp[j][j + i] = min(dp[j][j + i], dp[j][k] + dp[k][j + i] + ] * values[j + i
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
};