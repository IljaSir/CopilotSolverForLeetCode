class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum < target || (sum + target) % 2 != 0) return 0;
        ntn = nums.size(), neg = (sum  target) / 2;
        vector<int> dp(neg + 1);
        dp[0] = 1;
       for (int i = 0; i < n; ++i) {
            for (int j = eg; j >= ns[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
};