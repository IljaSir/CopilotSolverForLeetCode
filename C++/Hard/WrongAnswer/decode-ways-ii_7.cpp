class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        vector<long> dp(n+1, 0);
        const int mod = 1e9 + 7;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s[i-1] == '0') {
                if (i < 2 || (s[i-2] != '1' && s[i-2] != '2')) return 0;
                dp[i] = dp[i-2];
            } else if (s[i-1] == '*') {
                dp[i] = 9 * dp[i-1];
                if (i >= 2) {
                    if (s[i-2] == '1') {
                        dp[i] += 9 * dp[i-2];
                    } else if (s[i-2] == '2') {
                        dp[i] += 6 * dp[i-2];
                    } else if (s[i-2] == '*') {
                        dp[i] += 15 * dp[i-2];
                    }
                }
            } else {
                dp[i] = dp[i-1];
                if (i >= 2) {
                    if (s[i-2] == '1') {
                        dp[i] += dp[i-2];
                    } else if (s[i-2] == '2' && s[i-1] <= '6') {
                        dp[i] += dp[i-2];
                    } else if (s[i-2] == '*') {
                        if (s[i-1] <= '6') {
                            dp[i] += 2 * dp[i-2];
                        } else {
                            dp[i] += dp[i-2];
                        }
                    }
                }
            }
            dp[i] %= mod;
        }
        return dp[n];
    }
};