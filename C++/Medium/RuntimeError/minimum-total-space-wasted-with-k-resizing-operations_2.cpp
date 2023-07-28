class Solution {
public:
    int minSpaceWastedKResizing(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, INT_MAX / 2));
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k + 1; ++j) {
                int maxVal = 0;
                for (int p = i - 1; p >= 0; --p) {
                    maxVal = max(maxVal, nums[p]);
                    dp[i][j] = min(dp[i][j], dp[p][j - 1] + maxVal * (i - p) - (sum[i] - sum[p]));
                }
            }
        }
        return dp[n][k + 1];
    }
};