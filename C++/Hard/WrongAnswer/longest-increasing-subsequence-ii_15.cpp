class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] <= k) {
                    maxLen = max(maxLen, dp[j]);
                }
            }
            dp[i] = maxLen + 1;
            res = max(res, dp[i]);
        }
        return res;
    }
};