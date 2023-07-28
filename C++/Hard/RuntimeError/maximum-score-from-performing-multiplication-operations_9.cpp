class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size(), m = multipliers.size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        // dp[i][j] = max score of first i+1 elements + last j+1 elements
        for (int i = 0; i < m; ++i) {
            dp[i][0] = multipliers[i] * nums[i];
            if (i) dp[i][0] = max(dp[i][0], dp[i-1][0] + multipliers[i] * nums[i]);
        }
        for (int j = 1; j < m; ++j) {
            dp[0][j] = multipliers[j] * nums[n-j-1];
            if (j) dp[0][j] = max(dp[0][j], dp[0][j-1] + multipliers[j] * nums[n-j-1]);
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < m; ++j) {
                dp[i][j] = max(dp[i-1][j] + multipliers[i+j] * nums[i], dp[i][j-1] + multipliers[i+j] * nums[n-j-1]);
            }
        }
        return dp[m-1][m-1];
    }
};