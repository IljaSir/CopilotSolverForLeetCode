class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size() / 3;
        auto dp = vector<vector<int>>(n + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j]);
                if (j > 0) dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + slices[i - 1]);
            }
        }
        return dp[n][n - 1];
    }
};