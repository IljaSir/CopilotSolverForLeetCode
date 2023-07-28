class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        vector<int> dp(n, 0);
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < n; ++i) {
            minPrice = min(minPrice, prices[i]);
            maxProfit = max(maxProfit, prices[i] - minPrice);
            dp[i] = maxProfit;
        }
        int maxPrice = prices[n - 1];
        maxProfit = 0;
        int ans = 0;
        for (int i = n - 2; i >= 0; --i) {
            maxPrice = max(maxPrice, prices[i]);
            maxProfit = max(maxProfit, maxPrice - prices[i]);
            ans = max(ans, dp[i] + maxProfit);
        }
        return ans;
    }
};