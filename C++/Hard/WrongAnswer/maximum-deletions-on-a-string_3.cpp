class Solution {
public:
    int deleteString(string s) {
        
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
    int maximumDeletions(string s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, deleteString(s.substr(0, i)) + deleteString(s.substr(i)));
        }
        return ans;
    }
};