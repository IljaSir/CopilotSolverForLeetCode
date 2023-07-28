class Solution {
public:
    int deleteString(string s) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j * 2 <= i; ++j) {
                if (s.substr(0, j) == s.substr(j, j)) {
                    dp[i] = min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        return dp[n];
    }
};