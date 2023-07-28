class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        
        int n = s.length();
        vector<bool> dp(n + 1, false);
        dp[0] = true;
        for (int i = 0; i < n; ++i) {
            if (dp[i]) {
                for (string word : wordDict) {
                    int m = word.length();
                    if (i + m <= n && s.substr(i, m) == word) {
                        dp[i + m] = true;
                    }
                }
            }
        }
        return dp[n];
    }
};