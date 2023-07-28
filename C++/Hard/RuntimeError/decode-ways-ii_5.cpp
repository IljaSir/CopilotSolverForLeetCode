class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        int mod = 1e9 + 7;
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            char c = s[i - 1];
            if (c == '*') {
                // 1 digit
                dp[i] = 9 * dp[i - 1];
                // 2 digits
                if (i >= 2) {
                    if (s[i - 2] == '1') dp[i] = (dp[i] + 9 * dp[i - 2]) % mod;
                    else if (s[i - 2] == '2') dp[i] = (dp[i] + 6 * dp[i - 2]) % mod;
                    else if (s[i - 2] == '*') dp[i] = (dp[i] + 15 * dp[i - 2]) % mod;
                }
            } else {
                // 1 digit
                if (c != '0') dp[i] = dp[i - 1];
                // 2 digits
                if (i >= 2) {
                    if (s[i - 2] == '1' || (s[i - 2] == '2' && c <= '6')) dp[i] = (dp[i] + dp[i - 2]) % mod;
                    else if (s[i - 2] == '*') dp[i] = (dp[i] + (c <= '6' ? 2 : 1) * dp[i - 2]) % mod;
                }
            }
        }
        return dp[n];
    }
};