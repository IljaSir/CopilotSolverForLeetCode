class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.length();
        if (n == 0) return 0;
        if (s[0] == '0') return 0;
        int mod = 1000000007;
        vector<long long> dp(n+1, 0);
        dp[0] = 1;
        dp[1] = s[0] == '*' ? 9 : 1;
        for (int i = 2; i <= n; i++) {
            char c1 = s[i-2], c2 = s[i-1];
            if (c2 == '*') {
                dp[i] = 9 * dp[i-1];
            } else if (c2 != '0') {
                dp[i] = dp[i-1];
            }
            if (c1 == '*') {
                if (c2 == '*') {
                    dp[i] = (dp[i] + 15 * dp[i-2]) % mod;
                } else if (c2 <= '6') {
                    dp[i] = (dp[i] + 2 * dp[i-2]) % mod;
                } else {
                    dp[i] = (dp[i] + dp[i-2]) % mod;
                }
            } else if (c1 == '1') {
                if (c2 == '*') {
                    dp[i] = (dp[i] + 9 * dp[i-2]) % mod;
                } else {
                    dp[i] = (dp[i] + dp[i-2]) % mod;
                }
            } else if (c1 == '2') {
                if (c2 == '*') {
                    dp[i] = (dp[i] + 6 * dp[i-2]) % mod;
                } else if (c2 <= '6') {
                    dp[i] = (dp[i] + dp[i-2]) % mod;
                }
            }
        }
        return dp[n];
    }
};