class Solution {
public:
    int kInversePairs(int n, int k) {
        
        int dp[n+1][k+1];
        memset(dp, 0, sizeof(dp));
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                int sum = 0;
                for (int m = 0; m <= min(i-1, j); m++) {
                    sum += dp[i-1][j-m];
                    sum %= 1000000007;
                }
                dp[i][j] = sum;
            }
        }
        return dp[n][k];
    }
};