class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        int n = nums.size();
        vector<int> dp(1 << numSlots, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = (1 << numSlots) - 1; j >= 0; --j) {
                dp[j & nums[i]] = max(dp[j & nums[i]], dp[j] + nums[i]);
            }
        }
        return dp[0];
    }
};