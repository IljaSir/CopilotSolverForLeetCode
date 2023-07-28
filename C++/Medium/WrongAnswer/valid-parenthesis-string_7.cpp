class Solution {
public:
    bool checkValidString(string s) {
        
        int n = s.size();
        if (n == 0) return true;
        if (s[0] == ')') return false;
        vector<int> dp(n+1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s[i-1] == '*') {
                for (int j = 0; j <= i; j++) {
                    if (dp[j] > 0) {
                        if (j > 0) dp[j-1] = max(dp[j-1], dp[j] + 1);
                        if (j < i) dp[j+1] = max(dp[j+1], dp[j] + 1);
                        dp[j] = max(dp[j], dp[j] + 1);
                    }
                }
            } else if (s[i-1] == '(') {
                for (int j = i; j > 0; j--) {
                    dp[j] = dp[j-1];
                }
                dp[0] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    dp[j] = dp[j+1];
                }
                dp[i] = 0;
            }
        }
        return dp[0] > 0;
    }
};