class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        
        int n = nums.size();
        vector<long long> dp(n, 0);
        dp[0] = nums[0];
        long long res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            if (i % 2 == 0) {
                dp[i] += dp[i - 1];
            } else {
                dp[i] = max(dp[i], dp[i - 1] - nums[i]);
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};