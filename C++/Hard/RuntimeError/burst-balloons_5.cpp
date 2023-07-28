class Solution {
public:
    int maxCoins(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> val(n + 2);
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; ++i) {
            val[i] = nums[i - 1];
        }
        vector<vector<int>> dp(n + 2, vector<int>(n + 2, 0));
        for (int i = n; i > 0; --i) {
            for (int j = i; j <= n + 1; ++j) {
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = max(dp[i][j], dp[i][k - 1] + val[i - 1] * val[k] * val[j + 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][n];
    }
};