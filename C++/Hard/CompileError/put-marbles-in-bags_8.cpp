class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        long long sum = 0;
        int n = weights.size();
        for (int i = 0; i < k; ++i) {
            sum += weights[i];
        }
        long long ans = sum;
        for (int i = k; i < n; ++i) {
            sum += weights[i] - weights[i - k];
            ans = min(ans, sum);
        }
        return ans;
    }
    long long putMarbles2(vector<int>& weights, int k) {
        int n = weights.size();
        vector<long long> sum(n + 1);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + weights[i - 1];
        }
        vector<vector<long long>> dp(n + 1, vector<long long>(k + 1));
        for (int i = 1; i <= n; ++i) {
            dp[i][1] = sum[i];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 2; j <= k; ++j) {
                dp[i][j] = INT_MAX;
                for (int k = 1; k <= i; ++k) {
                    dp[i][j] = min(dp[i][j], max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][k];
    }
    long long putMarbles3(vector<int>& weights, int k) {
        int n = weights.size();
        vector<long long> sum(n + 1);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + weights[i - 1];
        }
        vector<vector<long long>> dp(n + 1, vector<long long>(k + 1));
        for (int i = 1; i <= n; ++i) {
            dp[i][1] = sum[i];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 2; j <= k; ++j) {
                dp[i][j] = INT_MAX;
                for (int k = j - 1; k <= i; ++k
    }
};