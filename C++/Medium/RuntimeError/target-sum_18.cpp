class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int n = nums.size();
        int sum = 0;
        for (auto n : nums) sum += n;
        if (sum < target) return 0;
        vector<vector<int>> dp(n + 1, vector<int>(2 * sum + 1, 0));
        dp[0][sum] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= 2 * sum; ++j) {
                int l = (j - nums[i - 1] >= 0) ? dp[i - 1][j - nums[i - 1]] : 0;
                int r = (j + nums[i - 1] <= 2 * sum) ? dp[i - 1][j + nums[i - 1]] : 0;
                dp[i][j] = l + r;
            }
        }
        return dp[n][sum + target];
    }
};