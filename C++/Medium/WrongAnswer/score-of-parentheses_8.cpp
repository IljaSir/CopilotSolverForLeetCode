class Solution {
public:
    int scoreOfParentheses(string s) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                dp[i + 1] = 0;
            } else {
                int j = i - 1;
                while (j >= 0 && s[j] == ')') {
                    j -= 2;
                }
                if (j >= 0) {
                    dp[i + 1] = dp[j] + dp[i + 1 - j] * 2;
                }
            }
        }
        return dp[n];
    }
};