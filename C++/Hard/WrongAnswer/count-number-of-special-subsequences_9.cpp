class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        int mod = 1e9 + 7;
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(3, 0));
        // dp[i][j] = number of special subsequences ending with j in nums[0...i]
        dp[0][nums[0]] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 1][2];
            if (nums[i] == 0) {
                dp[i][0] = (dp[i][0] + 1 + dp[i - 1][0]) % mod;
            } else if (nums[i] == 1) {
                dp[i][1] = (dp[i][1] + dp[i - 1][0] + dp[i - 1][1]) % mod;
            } else {
                dp[i][2] = (dp[i][2] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            }
        }
        return dp[n - 1][2];
    }
};