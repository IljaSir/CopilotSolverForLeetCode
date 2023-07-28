class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(5, 0));
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i > 0 && word[i] == 'a' + j) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
        }
        return ans;
    }
};