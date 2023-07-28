class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        int dp[n][n][k+1];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                dp[i][j][1] = max(nums[i], nums[j]);
            }
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i+len-1 < n; ++i) {
                int j = i+len-1;
                for (int m = 2; m <= k; ++m) {
                    for (int p = i; p < j; ++p) {
                        dp[i][j][m] = max(dp[i][j][m], min(dp[i][p][m-1], dp[p+1][j][1]));
                    }
                }
            }
        }
        return dp[0][n-1][k];
    }
};