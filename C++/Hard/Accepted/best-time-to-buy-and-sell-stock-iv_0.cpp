class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if (n == 0) return 0;
        if (k >= n / 2) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += max(prices[i] - prices[i - 1], 0);
            }
            return ans;
        }
        vector<vector<int>> dp(k + 1, vector<int>(n, 0));
        for (int i = 1; i <= k; i++) {
            int maxVal = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = max(dp[i][j - 1], prices[j] + maxVal);
                maxVal = max(maxVal, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
};