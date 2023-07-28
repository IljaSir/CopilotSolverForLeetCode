class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int n = nums.size();
        vector<vector<int>> dp(n+1, vector<int>(2001, 0));
        dp[0][1000] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int sum = -1000; sum <= 1000; ++sum) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + 1000 + nums[i - 1]] += dp[i - 1][sum + 1000];
                    dp[i][sum + 1000 - nums[i - 1]] += dp[i - 1][sum + 1000];
                }
            }
        }
        return dp[n][target + 1000];
    }
};