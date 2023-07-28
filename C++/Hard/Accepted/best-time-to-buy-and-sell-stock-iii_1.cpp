class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        if (n < 2) return 0;
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = max(left[i - 1], prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = max(right[i + 1], maxPrice - prices[i]);
            maxPrice = max(maxPrice, prices[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, left[i] + right[i]);
        }
        return res;
    }
};