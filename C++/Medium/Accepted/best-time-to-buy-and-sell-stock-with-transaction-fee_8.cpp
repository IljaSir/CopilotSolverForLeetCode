class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        
        int n = prices.size();
        if (n <= 1) return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < n; i++) {
            int tmp = buy;
            buy = max(buy, sell - prices[i]);
            sell = max(sell, tmp + prices[i] - fee);
        }
        return sell;
    }
};