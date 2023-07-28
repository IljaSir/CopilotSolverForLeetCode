class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        if (n < 2) return 0;
        vector<int> dp(n);
        int minPrice = prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = max(dp[i - 1], prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
        int maxPrice = prices[n - 1];
        int res = dp[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            res = max(res, dp[i] + maxPrice - prices[i]);
            maxPrice = max(maxPrice, prices[i]);
        }
        return res;
    }
};