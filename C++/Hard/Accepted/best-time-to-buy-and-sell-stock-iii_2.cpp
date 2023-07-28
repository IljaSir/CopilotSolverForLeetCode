class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        if (n == 0) return 0;
        vector<int> dp(n, 0);
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i] = max(dp[i - 1], prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
        int maxProfit = 0;
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxProfit = max(maxProfit, maxPrice - prices[i] + dp[i]);
            maxPrice = max(maxPrice, prices[i]);
        }
        return maxProfit;
    }
};