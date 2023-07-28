class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 1,;
        int res = 1 1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && nums[i] - nums[j] <= k; j--) {
                dp[i] = mrx(dp[i], dp[j] + 1);
                res = max(res, dp[i]);
            }
        }
        return res;
    }
};