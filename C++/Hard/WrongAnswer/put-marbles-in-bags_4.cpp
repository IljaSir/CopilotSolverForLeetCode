class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        int n = weights.size();
        vector<long long> sums(n+1, 0);
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + weights[i];
        }
        vector<vector<long long>> dp(k+1, vector<long long>(n+1, 0));
        for (int i = 1; i < n+1; i++) {
            dp[1][i] = sums[i];
        }
        for (int i = 2; i < k+1; i++) {
            for (int j = n; j >= i; j--) {
                dp[i][j] = INT_MAX;
                for (int p = i-1; p < j; p++) {
                    dp[i][j] = min(dp[i][j], max(dp[i-1][p], sums[j]-sums[p]));
                }
            }
        }
        return dp[k][n];
    }
    int minDifference(vector<int>& weights, int k) {
        int n = weights.size();
        if (k == 1) {
            return 0;
        }
        if (k == n) {
            return weights[n-1] - weights[0];
        }
        return putMarbles(weights, k);
    }
};