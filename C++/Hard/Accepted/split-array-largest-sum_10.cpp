class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<vector<int>> dp(k + 1, vector<int>(n + 1, INT_MAX));
        for (int i = 1; i <= n; i++) {
            dp[1][i] = sum[i];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int p = 1; p < j; p++) {
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][p], sum[j] - sum[p]));
                }
            }
        }
        return dp[k][n];
    }
};