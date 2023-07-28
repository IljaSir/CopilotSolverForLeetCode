class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        vector<vector<long long>> dp(n, vector<long long>(k + 1, 0));
        vector<long long> sum(n, 0);
        sort(costs.begin(), costs.end());
        sum[0] = costs[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + costs[i];
        for (int i = 0; i < n; i++) dp[i][1] = sum[i];
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = 1e18;
                for (int l = 1; l <= candidates && i - l >= 0; l++) {
                    dp[i][j] = min(dp[i][j], dp[i - l][j - 1] + sum[i] - sum[i - l]);
                }
            }
        }
        return dp[n - 1][k];
    }
};