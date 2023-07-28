class Solution {
public:
    int distinctSequences(int n) {
        
        const int mod = 1e9 + 7;
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(7, vector<int>(7, 0)));
        for (int i = 1; i <= 6; ++i) {
            dp[1][i][0] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 6; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    for (int p = 1; p <= 6; ++p) {
                        if (gcd(j, p) == 1) {
                            dp[i][j][k] += dp[i - 1][p][j];
                            dp[i][j][k] %= mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                ans += dp[n][i][j];
                ans %= mod;
            }
        }
        return ans;
    }
    int gcd(int a, int b) {
        if (a < b) {
            swap(a, b);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
};