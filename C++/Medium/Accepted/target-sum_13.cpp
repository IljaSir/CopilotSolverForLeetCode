class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        if (sum < target || (sum + target) % 2 != 0) return 0;
        int neg = (sum - target) / 2;
        vector<int> dp(neg + 1, 0);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = neg; j >= nums[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
};