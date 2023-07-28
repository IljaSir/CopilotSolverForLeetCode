class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> dp(1 << numSlots);
        for (int i = 0; i < n; i++) {
            vector<int> dp2 = dp;
            for (int j = 0; j < dp2.size(); j++) {
                dp[j & nums[i]] = max(dp[j & nums[i]], dp2[j] + (j & nums[i]));
            }
        }
        return dp.back();
    }
};