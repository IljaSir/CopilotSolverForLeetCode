class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i] = min(dp[i], max(dp[i - j], prefix[i] - prefix[i - j]));
            }
        }
        return dp[n];
    }
};