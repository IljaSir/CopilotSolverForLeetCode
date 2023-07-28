class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        int len = nums.size();
        if (len <= 1) return len;
        vector<int> dp(len, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] <= k) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            res = max(res, dp[i]);
        }
        return re
    }
};