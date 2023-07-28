class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long ans = 0;
        int n = prices.size();
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff == 1) {
                ans += i;
            }
        }
        return ans;
    }
};