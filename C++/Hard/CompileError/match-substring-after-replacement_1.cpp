class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        int n = s.length();
        int m = sub.length();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s[i - 1] == sub[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (dp[i][j] == 0) {
                    for (auto& v : mappings) {
                        if (v[0] == sub[j - 1] && v[1] == s[i - 1]) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
    bool isSubsequence(string s, string t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s[i] == t[j]) {
                i++;
            }
        }
        return i == s.length();
    }
    bool isPossible(string s, string sub, vector<vector<char>>& mappings) {
        if (!matchReplacement(s, sub, mappings)) {
            return false;
        }
        int n = s.length();
        int m = sub.length();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s[i - 1] == sub[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (dp[i][j] == 0) {
                    for (auto& v : mappings) {
                        if (v[
    }
};