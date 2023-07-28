class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long count = 0;
        for (int i = 1; i < prices.size(); ++i) {
            if (prices[i] < prices[i-1]) {
                count += prices[i-1] - prices[i];
            }
        }
        return count;
    }
};