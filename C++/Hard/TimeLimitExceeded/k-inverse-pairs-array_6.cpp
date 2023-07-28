class Solution {
public:
    int kInversePairs(int n, int k) {
        
        if (k == 0) return 1;
        if (n == 1) return 0;
        if (k > n * (n - 1) / 2) return 0;
        if (k == n * (n - 1) / 2) return 1;
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    for (int m = 0; m <= min(j, i - 1); m++) {
                        dp[i][j] += dp[i - 1][j - m];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        return dp[n][k];
    }
};