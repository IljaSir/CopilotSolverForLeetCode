class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(5, 0));
        for (int i = 0; i < n; i++) {
            if (word[i] == 'a') {
                dp[i][0] = 1;
            }
            if (word[i] == 'e') {
                dp[i][1] = 1;
            }
            if (word[i] == 'i') {
                dp[i][2] = 1;
            }
            if (word[i] == 'o') {
                dp[i][3] = 1;
            }
            if (word[i] == 'u') {
                dp[i][4] = 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
};