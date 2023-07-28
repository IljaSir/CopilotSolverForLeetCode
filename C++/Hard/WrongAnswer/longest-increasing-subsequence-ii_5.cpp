class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (abs(nums[i] - nums[j]) <= k) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};