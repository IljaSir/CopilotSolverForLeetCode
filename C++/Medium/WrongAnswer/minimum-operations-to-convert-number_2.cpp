class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        vector<int> dp(1001, -1);
        dp[start] = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> dp2(1001, -1);
            for (int j = 0; j < 1001; ++j) {
                if (dp[j] >= 0) {
                    if (j + nums[i] <= 1000) {
                        dp2[j + nums[i]] = max(dp2[j + nums[i]], dp[j] + 1);
                    }
                    if (j - nums[i] >= 0) {
                        dp2[j - nums[i]] = max(dp2[j - nums[i]], dp[j] + 1);
                    }
                    dp2[j ^ nums[i]] = max(dp2[j ^ nums[i]], dp[j] + 1);
                }
            }
            dp = dp2;
        }
        return dp[goal];
    }
};