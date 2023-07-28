class Solution {
public:
    int deleteString(string s) {
        
        int n = s.length();
        vector<int> dp(n + 1, 0);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    bool flag = true;
                    for (int k = j; k < i; k++) {
                        if (s[k] != s[k - j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        dp[i] = min(dp[i], 1 + dp[i / j]);
                    }
                }
            }
        }
        return dp[n];
    }
};