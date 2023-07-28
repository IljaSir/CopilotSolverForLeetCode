class Solution {
public:
    int kInversePairs(int n, int k) {
        
        vector<vector<int>> dp(n+1, vector<int>(k+1));
        const int MOD = 1000000007;
        dp[1][0] = 1;
        for (int i=2; i<=n; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=k; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i-1][j-i] + MOD) % MOD;
                }
            }
        }
        return dp[n][k];
    }
};