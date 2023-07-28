class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if (n == 0) return 0;
        if (k > n/2) {
            int ret = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]) {
                    ret += prices[i] - prices[i-1];
                }
            }
            return ret;
        }
        vector<int> dp(n, 0);
        for (int t = 0; t < k; t++) {
            int tmp = dp[0] - prices[0];
            for (int i = 1; i < n; i++) {
                dp[i] = max(dp[i-1], prices[i] + tmp);
                tmp = max(tmp, dp[i] - prices[i]);
            }
        }
        return dp[n-1];
    }
};