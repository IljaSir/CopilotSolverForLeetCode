class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1);
        for (int i = 0; i < n; ++i) sum[i+1] = sum[i] + nums[i];
        vector<int> dp(n);
        for (int i = 0; i < n; ++i) dp[i] = sum[n] - sum[i];
        for (int i = 1; i < k; ++i) {
            vector<int> ndp(n);
            for (int j = 0; j < n; ++j) {
                ndp[j] = dp[j];
                for (int k = j+2; k < n; ++k) {
                    ndp[j] = min(ndp[j], max(dp[k], sum[k] - sum[j]));
                }
            }
            dp = move(ndp);
        }
        return dp[0];
    }
};