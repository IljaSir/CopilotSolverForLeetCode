class Solution {
public:
    int minInsertions(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j + 1]) + 1;
                }
            }
        }
        return dp[n - 1][0];
    }
};