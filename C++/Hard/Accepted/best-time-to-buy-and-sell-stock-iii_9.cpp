class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        if (n <= 1) return 0;
        int min = prices[0];
        int max = prices[n - 1];
        vector<int> profit(n, 0);
        for (int i = 1; i < n; i++) {
            min = std::min(min, prices[i]);
            profit[i] = std::max(profit[i - 1], prices[i] - min);
        }
        int maxProfit = profit[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = std::max(max, prices[i]);
            maxProfit = std::max(maxProfit, profit[i] + max - prices[i]);
        }
        return maxProfit;
    }
};