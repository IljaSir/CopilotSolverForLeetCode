class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        vector<long long> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = s[0] == '*' ? 9 : s[0] == '0' ? 0 : 1;
        for (int i = 2; i <= n; ++i) {
            if (s[i - 1] == '*') {
                dp[i] = dp[i - 1] * 9;
                if (s[i - 2] == '1') dp[i] += dp[i - 2] * 9;
                if (s[i - 2] == '2') dp[i] += dp[i - 2] * 6;
                if (s[i - 2] == '*') dp[i] += dp[i - 2] * 15;
            } else {
                dp[i] = s[i - 1] != '0' ? dp[i - 1] : 0;
                if (s[i - 2] == '1') dp[i] += dp[i - 2];
                if (s[i - 2] == '2' && s[i - 1] <= '6') dp[i] += dp[i - 2];
                if (s[i - 2] == '*') dp[i] += dp[i - 2] * (s[i - 1] <= '6' ? 2 : 1);
            }
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
};