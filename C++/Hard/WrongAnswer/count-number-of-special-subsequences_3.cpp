class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1000000007;
        vector<int> dp(3);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                dp[0] = (dp[0] * 2) % mod;
            } else if (nums[i] == 1) {
                dp[1] = (dp[0] + 2 * dp[1]) % mod;
            } else {
                dp[2] = (dp[1] + 2 * dp[2]) % mod;
            }
        }
        return dp[2];
    }
};