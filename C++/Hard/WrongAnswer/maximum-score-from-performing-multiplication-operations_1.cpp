class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size(), m = multipliers.size();
        vector<vector<int>> dp(m + 1, vector<int>(m + 1, INT_MIN));
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = max(dp[i - 1][j - 1] + nums[n - i + j - 1] * multipliers[i - 1],
                               dp[i - 1][j] + nums[j - 1] * multipliers[i - 1]);
            }
        }
        return *max_element(dp[m].begin(), dp[m].end());
    }
};