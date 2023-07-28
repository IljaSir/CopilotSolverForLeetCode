class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        int n = weights.size();
        vector<long long> prefixSum(n + 1);
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + weights[i];
        }
        vector<vector<long long>> dp(k, vector<long long>(n, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[0][i] = prefixSum[i + 1] * 2 - prefixSum[0];
        }
        for (int i = 1; i < k; ++i) {
            for (int j = i; j < n; ++j) {
                for (int p = i - 1; p < j; ++p) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][p] + (prefixSum[j + 1] - prefixSum[p + 1]) * 2 - (prefixSum[p + 1] - prefixSum[i - 1]));
                }
            }
        }
        return dp[k - 1][n - 1];
    }
};