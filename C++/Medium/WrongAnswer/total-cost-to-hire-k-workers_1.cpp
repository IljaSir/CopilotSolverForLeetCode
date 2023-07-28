class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        sort(costs.begin(), costs.end());
        int n = costs.size();
        vector<long long> dp(n);
        dp[0] = costs[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + costs[i];
        }
        long long ans = dp[candidates - 1];
        for (int i = 1; i < k; ++i) {
            long long best = LLONG_MAX;
            for (int j = 0; j < candidates; ++j) {
                int idx = i * candidates + j;
                if (idx >= n) break;
                best = min(best, dp[idx] - (idx - candidates >= 0 ? dp[idx - candidates] : 0));
            }
            ans += best;
        }
        return ans;
    }
};