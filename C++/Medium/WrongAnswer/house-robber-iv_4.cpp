class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        vector<int> sum(n, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            vector<int> tmp(n, 0);
            for (int j = i; j < n; j++) {
                tmp[j] = dp[j-1];
                if (j > i) {
                    tmp[j] = min(tmp[j], tmp[j-1]);
                }
                tmp[j] = max(tmp[j], sum[j] - sum[j-i]);
            }
            dp = tmp;
        }
        return dp[n-1];
    }
};