class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        vector<int> f(n);
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = min(minPrice, prices[i]);
            f[i] = max(f[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[n - 1];
        int maxProfit = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = max(maxPrice, prices[i]);
            maxProfit = max(maxProfit, maxPrice - prices[i] + f[i]);
        }
        return maxProfit;
    }
};