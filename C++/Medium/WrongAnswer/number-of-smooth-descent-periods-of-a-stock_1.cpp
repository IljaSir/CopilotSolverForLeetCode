class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        int n = prices.size();
        long long dp[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i] == prices[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i];
        }
        return ans;
    }
};