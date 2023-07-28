class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        vector<vector<long long>> dp(k, vector<long long>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[0][i] = costs[i];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + costs[j];
                for (int x = 2; x <= candidates; ++x) {
                    if (j - x < i - 1) break;
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - x] + costs[j]);
                }
            }
        }
        long long ans = dp[k - 1][n - 1];
        for (int i = 1; i <= candidates; ++i) {
            ans = min(ans, dp[k - 1][n - i]);
        }
        return ans;
    }
};