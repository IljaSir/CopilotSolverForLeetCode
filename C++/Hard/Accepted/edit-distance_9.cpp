class Solution {
public:
    int minDistance(string word1, string word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return len1 + len2;
        }
        vector<vector<int>> dp(len1 + 1, vector<int>(len2 + 1, 0));
        for (int i = 0; i <= len1; ++i) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
};