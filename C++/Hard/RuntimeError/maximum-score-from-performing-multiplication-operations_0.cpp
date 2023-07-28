class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size(), m = multipliers.size();
        vector<vector<int>> dp(m + 1, vector<int>(m + 1, INT_MIN));
        dp[0][0] = 0;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + nums[j - 1] * multipliers[i - 1]);
                }
                if (i - 1 >= 0 && j >= 0) {
                    dp[i][j] = max(dp[i][j], dp[i - 1][j] + nums[n - i + j] * multipliers[i - 1]);
                }
            }
        }
        int ans = INT_MIN;
        for (int j = 0; j <= m; ++j) {
            ans = max(ans, dp[m][j]);
        }
        return ans;
    }
};