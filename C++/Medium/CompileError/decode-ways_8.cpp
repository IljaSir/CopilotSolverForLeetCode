class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        int dp[n+1];
        dp[0] = 1;
        dp[1] = s[0] == '0' ? 0 : 1;
        for (int i = 2; i <= n; ++i) {
            int first = stoi(s.substr(i-1, 1));
            intecond = s);
            if (first >= 1 && first <= 9 {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second
        for (int i = 1; i <= n; ++i) {
            if (s[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && s[i - 2] != '0' && (s[i - 2] - '0') * 10 + (s[i - 1] - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
};