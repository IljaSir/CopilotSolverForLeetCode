class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int sum = (sum - target) / 2;
        vector<int> dp(neg + 1, 0);
        dp[0] = 1;
        for (int num : nums) {
            for (int i = neg; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }uto num: nums) {
            for (int i = neg; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }
        retrn dp[neg];
    }
};