class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        if (prices.size() < 2) return 0;
        int n = prices.size();
        vector<int> dp(n);
        dp[0] = 0;
        dp[1] = max(0, prices[1] - prices[0]);
        for (int i = 2; i < n; ++i) {
            dp[i] = max(dp[i - 1], dp[i - 2] + prices[i] - prices[i - 1]);
        }
        return dp[n - 1];
    }
};