class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(3, 0));
        if (nums[0] == 0) dp[0][0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == 0) {
                dp[i][0] = (dp[i-1][0] * 2 + 1) % 1000000007;
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-1][2];
            } else if (nums[i] == 1) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = (dp[i-1][1] * 2 + dp[i-1][0]) % 1000000007;
                dp[i][2] = dp[i-1][2];
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                dp[i][2] = (dp[i-1][2] * 2 + dp[i-1][1]) % 1000000007;
            }
        }
        return dp[n-1][2];
    }
};