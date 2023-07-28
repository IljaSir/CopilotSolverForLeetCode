class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size(), m = multipliers.size();
        vector<vector<int>> dp(m + 1, vector<int>(m + 1));
        for (int i = 0; i < m; ++i) {
            dp[i + 1][0] = dp[i][0] + nums[i] * multipliers[i];
            dp[0][i + 1] = dp[0][i] + nums[n - i - 1] * multipliers[i];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = max(dp[i - 1][j] + nums[i - 1] * multipliers[i + j - 1], dp[i][j - 1] + nums[n - j] * multipliers[i + j - 1]);
            }
        }
        int res = INT_MIN;
        for (int i = 0; i <= m; ++i) {
            res = max(res, dp[i][m - i]);
        }
        return res;
    }
};