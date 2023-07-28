class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if (n <= 1) return 0;
        if (k > n/2) {
            int ans = 0;
            for (int i = 1; i < n; ++i) {
                ans += max(0, prices[i] - prices[i-1]);
            }
            return ans;
        }
        vector<int> buy(k+1, INT_MIN);
        vector<int> sell(k+1, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                buy[j] = max(buy[j], sell[j-1] - prices[i]);
                sell[j] = max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
};