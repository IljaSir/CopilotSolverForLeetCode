class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        if (n == 0) return 0;
        int i = 0, j = 1;
        int profit = 0;
        while (j < n) {
            if (prices[j] > prices[i]) {
                profit += prices[j] - prices[i];
                i = j;
            }
            j++;
        }
        return profit;
    }
};