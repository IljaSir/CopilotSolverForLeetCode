class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long n = prices.size();
        long long ans = 0;
        for (int i = 1; i < n; ++i) {
            int diff = prices[i] - prices[i-1];
            if (diff == 1) {
                ans += i;
            } else if (diff > 1) {
                ans += (i*(i+1))/2;
            }
        }
        return ans;
    }
};