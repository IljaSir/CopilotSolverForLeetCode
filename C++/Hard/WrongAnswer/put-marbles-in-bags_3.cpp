class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        int n = weights.size();
        vector<long long> sum(n+1);
        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + weights[i];
        }
        vector<vector<long long>> dp(n, vector<long long>(k+1, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[i][1] = sum[i+1];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 2; j <= k; ++j) {
                for (int x = 0; x < i; ++x) {
                    dp[i][j] = min(dp[i][j], dp[x][j-1] + sum[i+1] - sum[x+1]);
                }
            }
        }
        return dp[n-1][k];
    }
};