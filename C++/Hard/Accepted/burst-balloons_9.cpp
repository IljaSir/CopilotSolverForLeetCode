class Solution {
public:
    int maxCoins(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> val(n + 2);
        vector<vector<int>> dp(n + 2, vector<int>(n + 2, 0));
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                for (int k = l; k <= r; k++) {
                    dp[l][r] = max(dp[l][r], dp[l][k - 1] + val[l - 1] * val[k] * val[r + 1] + dp[k + 1][r]);
                }
            }
        }
        return dp[1][n];
    }
};