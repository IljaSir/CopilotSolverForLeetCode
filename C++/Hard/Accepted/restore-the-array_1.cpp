class Solution {
public:
    int numberOfArrays(string s, int k) {
        
        int n = s.length();
        int mod = 1e9 + 7;
        vector<long> dp(n + 1, 0);
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '0') {
                continue;
            }
            long num = 0;
            for (int j = i; j < n; j++) {
                num = num * 10 + (s[j] - '0');
                if (num > k) {
                    break;
                }
                dp[i] = (dp[i] + dp[j + 1]) % mod;
            }
        }
        return dp[0];
    }
};