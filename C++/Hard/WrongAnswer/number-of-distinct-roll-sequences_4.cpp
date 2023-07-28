class Solution {
public:
    int distinctSequences(int n) {
        
        int mod = 1e9 + 7;
        vector<vector<long>> dp(n + 1, vector<long>(6, 0));
        for (int i = 0; i < 6; ++i) dp[1][i] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < 6; ++j) {
                for (int k = 0; k < 6; ++k) {
                    if (gcd(j + 1, k + 1) == 1) dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 6; ++i) ans = (ans + dp[n][i]) % mod;
        return ans;
    }
    int gcd(int a, int b) {
        if (a < b) swap(a, b);
        while (b) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
};