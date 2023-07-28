class Solution {
public:
    long long sellingWood(int m, int n, vector<vector<int>>& prices) {
        
        int len = prices.size();
        vector<vector<long long>> dp(m+1, vector<long long>(n+1, 0));
        for (int i = 0; i < len; i++) {
            for (int j = prices[i][0]; j <= m; j++) {
                for (int k = prices[i][1]; k <= n; k++) {
                    dp[j][k] = max(dp[j][k], dp[j-prices[i][0]][k-prices[i][1]] + prices[i][2]);
                }
            }
        }
        return dp[m][n];
    }
};