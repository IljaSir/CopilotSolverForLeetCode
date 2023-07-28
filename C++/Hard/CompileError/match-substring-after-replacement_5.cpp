class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        int n = s.length();
        int m = sub.length();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s[i] == sub[j]) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    for (auto& mapping : mappings) {
                        if (mapping[0] == sub[j]) {
                            if (mapping[1] == s[i]) {
                                dp[i+1][j+1] = dp[i][j];
                            }
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
    bool isSubsequence(string s, string sub) {
        int n = s.length();
        int m = sub.length();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s[i] == sub[j]) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[n][m];
    }
    bool isMatch(string s, string sub, vector<vector<char>>& mappings) {
        if (isSubsequence(s, sub)) {
            return true;
        }
        int n = s.length();
        int m = sub.length();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m;
    }
};