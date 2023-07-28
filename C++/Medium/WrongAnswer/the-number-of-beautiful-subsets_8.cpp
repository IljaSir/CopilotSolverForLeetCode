class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]
        int n = nums.size();
        vector<vector<int>> dp(n+1, vector<int>(1001, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= 1000; ++j) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 1000; ++i) {
            if (i == 0 || abs(i-k) != k) {
                ans += dp[n][i];
            }
        }
        return ans;
    }
};