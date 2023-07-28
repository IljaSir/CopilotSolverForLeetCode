class Solution {
public:
    int numDecodings(string s) {
        
        const int mod = 1e9 + 7;
        int n = s.size();
        vector<long long> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s[i - 1] == '*') {
                dp[i] = dp[i - 1] * 9;
                if (i >= 2) {
                    if (s[i - 2] == '1') {
                        dp[i] += dp[i - 2] * 9;
                    } else if (s[i - 2] == '2') {
                        dp[i] += dp[i - 2] * 6;
                    } else if (s[i - 2] == '*') {
                        dp[i] += dp[i - 2] * 15;
                    }
                }
            } else {
                dp[i] = s[i - 1] != '0' ? dp[i - 1] : 0;
                if (i >= 2) {
                    if (s[i - 2] == '1') {
                        dp[i] += dp[i - 2];
                    } else if (s[i - 2] == '2' && s[i - 1] <= '6') {
                        dp[i] += dp[i - 2];
                    } else if (s[i - 2] == '*') {
                        dp[i] += dp[i - 2] * (s[i - 1] <= '6' ? 2 : 1);
                    }
                }
            }
            dp[i] %= mod;
        }
        return dp[n];
    }
};