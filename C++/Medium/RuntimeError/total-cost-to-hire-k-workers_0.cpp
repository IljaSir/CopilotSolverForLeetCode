class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        vector<vector<long long>> dp(k + 1, vector<long long>(n + 1, LLONG_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int l = 1; l <= candidates && l <= j; l++) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - l] + *min_element(costs.begin() + j - l, costs.begin() + j));
                }
            }
        }
        return dp[k][n];
    }
};