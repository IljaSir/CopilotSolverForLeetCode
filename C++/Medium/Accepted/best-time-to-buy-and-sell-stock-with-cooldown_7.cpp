class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        int sell = 0, buy = INT_MIN, pre_sell = 0, pre_buy = 0;
        for (int i = 0; i < n; ++i) {
            pre_buy = buy;
            buy = max(pre_sell - prices[i], pre_buy);
            pre_sell = sell;
            sell = max(pre_buy + prices[i], pre_sell);
        }
        return sell;
    }
};