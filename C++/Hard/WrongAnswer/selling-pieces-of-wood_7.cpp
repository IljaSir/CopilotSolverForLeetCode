class Solution {
public:
    long long sellingWood(int m, int n, vector<vector<int>>& prices) {
        
        // sort the prices
        sort(prices.begin(), prices.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] * a[1] < b[0] * b[1];
        });
        // dp[i][j] is the max money can get by cutting a piece of wood with height i and width j
        vector<vector<long long>> dp(m + 1, vector<long long>(n + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = max(dp[i][j], (long long)i * j);
                for (auto& price : prices) {
                    if (i >= price[0] && j >= price[1]) {
                        dp[i][j] = max(dp[i][j], dp[i - price[0]][j - price[1]] + price[2]);
                    }
                }
            }
        }
        return dp[m][n];
    }
};