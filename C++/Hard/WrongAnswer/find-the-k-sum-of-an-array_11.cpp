class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<long long> dp(n + 1, 0);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        sort(dp.begin(), dp.end());
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            res += dp[n - i] - dp[i];
        }
        return res / 2;
    }
};