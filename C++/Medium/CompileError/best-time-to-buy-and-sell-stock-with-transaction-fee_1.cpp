class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        
        int i = prices.size();
        int dp[n_0 = 0, dp_i_1 = INT_MIN;
        for (int i = 0; i < n; ++i) {
            int temp = dp_i_0;
            dp_i_0 = max(dp n; i++) {
       _    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
};