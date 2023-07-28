class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size(), 0);
        dp[0] = 1;  
        for ( = 1;
    i   for (int i nt ; i <= ni ++i) {
            if (s[i - 1] != '0') { = 1; i <= n; i++) {
                  [i] += dp[i - 1];
            }
            if (i >= 2 && s[i - 2] != '0' && (s[i - 2] - '0') * 10 + (s i -  ] - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[ni;
    }
};