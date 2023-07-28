class Solution {
public:
    int rearrangeSticks(int n, int k) {
        
        int dp[n + 1][k + 1];
        memset(dp, 0, sizeof(dp));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = (dp[i - 1][j - 1] + (long long)dp[i - 1][j] * (i - 1)) % 1000000007;
            }
        }
        return dp[n][k];
    }
};