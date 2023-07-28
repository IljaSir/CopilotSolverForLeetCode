class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if (n == 0) return 0;
        if (k > n/2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]) res += prices[i] - prices[i-1];
            }
            return res;
        }
        vector<vector<int>> dp(n, vector<int>(k+1, 0));
        for (int i = 1; i <= k; i++) {
            int maxVal = INT_MIN;
            for (int j = 1; j < n; j++) {
                maxVal = max(maxVal, dp[j-1][i-1] - prices[j-1]);
                dp[j][i] = max(dp[j-1][i], prices[j] + maxVal);
            }
        }
        return dp[n-1][k];
    }
};