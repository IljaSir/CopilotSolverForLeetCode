class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        vector<int> dp(n, 0);
        int min_price = prices[0];
        for (int i = 1; i < n; i++) {
            min_price = min(min_price, prices[i]);
            dp[i] = max(dp[i - 1], prices[i] - min_price);
        }
        int max_price = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max_price = max(max_price, prices[i]);
            dp[i] = max(dp[i + 1], dp[i] + max_price - prices[i]);
        }
        return dp[0];
    }
};