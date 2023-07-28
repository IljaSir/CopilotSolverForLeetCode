class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<long long> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<vector<long long>> dp(k + 1, vector<long long>(n + 1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            for (int j = i; j <= n; ++j) {
                for (int t = 0; t < j; ++t) {
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][t], sum[j] - sum[t]));
                }
            }
        }
        return dp[k][n];
    }
};