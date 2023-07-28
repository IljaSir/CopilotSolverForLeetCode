class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.length();
        int dp[n][5];
        memset(dp, 0, sizeof dp);
        
        for (int i = 0; i < n; ++i) {
            if (word[i] == 'a') {
                dp[i][0] = 1;
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (word[i] == 'e') {
                for (int j = 0; j < i; ++j) {
                    dp[i][1] += dp[j][0];
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (word[i] == 'i') {
                for (int j = 0; j < i; ++j) {
                    dp[i][2] += dp[j][1];
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (word[i] == 'o') {
                for (int j = 0; j < i; ++j) {
                    dp[i][3] += dp[j][2];
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (word[i] == 'u') {
                for (int j = 0; j < i; ++j) {
                    dp[i][4] += dp[j][3];
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 5; ++j) {
                ans += dp[i][j];
            }
        }
        
        return ans;
    }
};