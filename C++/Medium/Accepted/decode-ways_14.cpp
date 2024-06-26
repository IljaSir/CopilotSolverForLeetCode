class Solution {
public:
    int numDecodings(string s) {
        
        if (s.empty()) return 0;
        if (s[0] == '0') return 0;
        int n = s.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int first = s[i - 1] - '0';
            int second = (s[i - 2] - '0') * 10 + first;
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
};