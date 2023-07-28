class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> sum(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
            sum[i][i] = 1;
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                for (int k = i; k <= j; ++k) {
                    int left = k == i ? 1 : dp[i][k - 1];
                    int right = k == j ? 1 : dp[k + 1][j];
                    dp[i][j] = (dp[i][j] + (long long)left * right) % mod;
                }
                for (int k = i + 1; k <= j; ++k) {
                    sum[i][j] = (sum[i][j] + sum[i][k - 1] * dp[k][j]) % mod;
                }
                for (int k = i; k < j; ++k) {
                    sum[i][j] = (sum[i][j] + sum[k + 1][j] * dp[i][k]) % mod;
                }
            }
        }
        return (dp[0][n - 1] - 1 + mod) % mod;
    }
};