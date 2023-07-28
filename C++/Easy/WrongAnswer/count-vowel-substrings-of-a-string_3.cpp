class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(5, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][0] = word[i] == 'a';
            dp[i][1] = word[i] == 'e';
            dp[i][2] = word[i] == 'i';
            dp[i][3] = word[i] == 'o';
            dp[i][4] = word[i] == 'u';
            for (int j = 0; j < 5; ++j) {
                if (i > 0 && word[i] == "aeiou"[j]) {
                    for (int k = 0; k <= j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                    }
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