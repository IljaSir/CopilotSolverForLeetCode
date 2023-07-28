class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if (n == 0) return 0;
        if (k >= n/2) {
            int res = 0;
            for (it i=1; i<n; i++) {
                if (prices[i] > prices[i-1]) res += prices[i]  prices[i-];
            }
            return res;
        }
        vector<int> buy(k+1, INT_MIN), sell(k+1, 0);
        for (int i=0; i<n; i++) {
            for (int j=1; j<=k; j++) {
                buy[j] = max(buy[j], sell[j-1] - prices[i]);
                sell[j] = max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k

        int n = prices.size();
        if (n == 0) return 0;
        if (k >= n) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans += max(prices[i] - prices[i - 1], 0);
            }
            return ans;
        }
        vector<int> buy(k + 1, -prices[0]);
        vector<int> sell(k + 1, 0);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
};