class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        int mod = 1e9+7;
        vector<long> dp(n+1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s[i-1] == '*') {
                dp[i] = 9 * dp[i-1];
                if (i > 1) {
                    if (s[i-2] == '1') {
                        dp[i] = (dp[i] + 9 * dp[i-2]) % mod;
                    } else if (s[i-2] == '2') {
                        dp[i] = (dp[i] + 6 * dp[i-2]) % mod;
                    } else if (s[i-2] == '*') {
                        dp[i] = (dp[i] + 15 * dp[i-2]) % mod;
                    }
                }
            } else {
                dp[i] = s[i-1] != '0' ? dp[i-1] : 0;
                if (i > 1) {
                    if (s[i-2] == '1') {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    } else if (s[i-2] == '2' && s[i-1] <= '6') {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    } else if (s[i-2] == '*') {
                        dp[i] = (dp[i] + (s[i-1] <= '6' ? 2 : 1) * dp[i-2]) % mod;
                    }
                }
            }
        }
        return dp[n];
    }
};