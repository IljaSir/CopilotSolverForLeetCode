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
        return dp[n][sum + target: nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int neg = (sum - target) / 2;
        vector<int> dp(neg + 1);
        dp[0] = 1;
        for (auto num: nums) {
            for (int i = neg; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }
};