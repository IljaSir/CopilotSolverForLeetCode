class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int sum = ac.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int neg = (sum - target) / 2;
        vector<int> dp(neg + 1);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
};