class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        vector<vector<int>> dp(k+1, vector<int>(n+1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int p = i-1; p < j; p++) {
                    dp[i][j] = min(dp[i][j], max(dp[i-1][p], sum[j] - sum[p]));
                }
            }
        }
        return dp[k][n];
    }
};