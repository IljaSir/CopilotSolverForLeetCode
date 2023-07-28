class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        
        int n = nums.size();
        int dp[n+1][k+1];
        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] % j == 0) {
                    dp[i][j] += dp[i-1][__gcd(j, nums[i-1])] + 1;
                }
            }
        }
        return dp[n][k];
    }
};