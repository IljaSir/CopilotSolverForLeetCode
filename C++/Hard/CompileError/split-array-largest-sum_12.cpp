class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (it i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        vector<vector<int>> dp(n+1, vector<int>(k+1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = min(dp[i][j], max(dp[l][j-1], sum[i]-sum[l]));
                }
            }
        }
        return dp[n][k];
    }
};