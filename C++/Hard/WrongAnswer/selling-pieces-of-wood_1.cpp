class Solution {
public:
    long long sellingWood(int m, int n, vector<vector<int>>& prices) {
        
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (auto p : prices) {
            for (int i = p[0]; i <= m; ++i) {
                for (int j = p[1]; j <= n; ++j) {
                    dp[i][j] = max(dp[i][j], dp[i - p[0]][j - p[1]] + p[2]);
                }
            }
        }
        return dp[m][n];
    }
};