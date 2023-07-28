class Solution {
public:
    int longestValidParentheses(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        int dp[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            if (s[i-1] == '(') {
                dp[i] = 0;
            } else {
                if (s[i-2] == '(') {
                    dp[i] = dp[i-2] + 2;
                } else {
                    int match = i - dp[i-1] - 2;
                    if (match >= 0 && s[match] == '(') {
                        dp[i] = dp[i-1] + 2 + dp[match];
                    } else {
                        dp[i] = 0;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res = max(res, dp[i]);
        }
        return res;
    }
};