class Solution {
public:
    int distinctSequences(int n) {
        
        int MOD = 1000000007;
        vector<vector<long long>> dp(n + 1, vector<long long>(7, 0));
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (__gcd(j, k) == 1) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        long long ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans += dp[n][i];
            ans %= MOD;
        }
        return ans;
    }
};