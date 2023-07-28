class Solution {
public:
    long long sellingWood(int m, int n, vector<vector<int>>& prices) {
        
        vector<vector<long long>> dp(m+1, vector<long long>(n+1, 0));
        for (auto& p : prices) {
            int h = p[0], w = p[1], price = p[2];
            for (int i = h; i <= m; ++i) {
                for (int j = w; j <= n; ++j) {
                    dp[i][j] = max(dp[i][j], dp[i-h][j-w] + price);
                }
            }
        }
        return dp[m][n];
    }
};