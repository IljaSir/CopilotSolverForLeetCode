class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        if (n == 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;
        for (int i = 1; i < n; i++) {
            int tmp = buy;
            buy = max(buy, cooldown - prices[i]);
            cooldown = sell;
            sell = max(sell, tmp + prices[i]);
        }
        return sell;
    }
};