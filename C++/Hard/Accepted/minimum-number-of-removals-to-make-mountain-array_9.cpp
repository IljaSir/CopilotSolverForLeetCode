class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            int maxLen = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    maxLen = max(maxLen, dp[j]);
                }
            }
            dp[i] = maxLen + 1;
        }
        vector<int> dp2(n, 0);
        for (int i = n - 1; i >= 0; --i) {
            int maxLen = 0;
            for (int j = n - 1; j > i; --j) {
                if (nums[j] < nums[i]) {
                    maxLen = max(maxLen, dp2[j]);
                }
            }
            dp2[i] = maxLen + 1;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] > 1 && dp2[i] > 1) {
                ans = max(ans, dp[i] + dp2[i] - 1);
            }
        }
        return n - ans;
    }
};