class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        int n = nums.size();
        int m = numSlots;
        vector<vector<int>> dp(n, vector<int>(m, 0));
        dp[0][0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][0] | nums[i];
        }
        for (int j = 1; j < m; ++j) {
            dp[j][j] = dp[j - 1][j - 1] | nums[j];
            for (int i = j + 1; i < n; ++i) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] | nums[i]);
            }
        }
        return dp[n - 1][m - 1];
    }
};