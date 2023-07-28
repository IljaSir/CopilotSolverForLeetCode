class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        int n = nums.size();
        int m = 1 << numSlots;
        vector<int> dp(m, -1);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = m - 1; j >= 0; --j) {
                if (dp[j] >= 0) {
                    dp[j | (1 << i)] = max(dp[j | (1 << i)], dp[j] + nums[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            res = max(res, dp[i] & i);
        }
        return res;
    }
};