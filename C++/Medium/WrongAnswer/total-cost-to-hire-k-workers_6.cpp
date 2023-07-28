class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            dp[i] = costs[i];
            if (i >= candidates) {
                dp[i] += dp[i - candidates];
            }
            if (i >= 1) {
                dp[i] = min(dp[i], dp[i - 1]);
            }
        }
        long long ans = 0;
        for (int i = n - 1; i >= n - candidates; --i) {
            ans += dp[i];
        }
        for (int i = 0; i < k - 1; ++i) {
            ans += dp[n - candidates - 1];
        }
        return ans;
    }
};