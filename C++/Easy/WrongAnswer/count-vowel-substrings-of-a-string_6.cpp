class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.size();
        int dp[5][n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            if (word[i] == 'a') {
                dp[0][i] = 1;
            } else if (word[i] == 'e') {
                dp[1][i] = 1;
            } else if (word[i] == 'i') {
                dp[2][i] = 1;
            } else if (word[i] == 'o') {
                dp[3][i] = 1;
            } else if (word[i] == 'u') {
                dp[4][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (i > 0 && dp[j][i] > 0) {
                    dp[j][i] += dp[j][i - 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += dp[i][n - 1];
        }
        return res;
    }
};