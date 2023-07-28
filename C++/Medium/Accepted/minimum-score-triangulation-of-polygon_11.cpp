class Solution {
public:
    int minScoreTriangulation(vector<int>& values) {
        
        const int N = values.size();
        vector<vector<int>> dp(N, vector<int>(N, 0));
        for (int i = 0; i < N - 2; ++i) {
            for (int j = 0; j < N - i - 2; ++j) {
                int k = i + j + 2;
                dp[j][k] = INT_MAX;
                for (int m = j + 1; m < k; ++m) {
                    dp[j][k] = min(dp[j][k], dp[j][m] + dp[m][k] + values[j] * values[m] * values[k]);
                }
            }
        }
        return dp[0][N - 1];
    }
};