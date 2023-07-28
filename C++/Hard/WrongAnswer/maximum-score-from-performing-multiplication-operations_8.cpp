class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int m = multipliers.size();
        int n = nums.size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        for (int i = 0; i < m; i++) {
            dp[i][i] = multipliers[i] * nums[i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                dp[j][j + i] = max(multipliers[j] * nums[j] + dp[j + 1][j + i], multipliers[j + i] * nums[n - i + j] + dp[j][j + i - 1]);
            }
        }
        return dp[0][m - 1];
    }
};