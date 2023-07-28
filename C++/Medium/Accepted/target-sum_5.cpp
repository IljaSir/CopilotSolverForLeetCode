class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 == 1) {
            return 0;
        }
        int neg = (sum - target) / 2;
        vector<int> dp(neg + 1, 0);
        dp[0] = 1;
        for (int num: nums) {
            for (int i = neg; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }
};