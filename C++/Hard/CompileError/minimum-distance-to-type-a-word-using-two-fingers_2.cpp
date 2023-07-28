class Solution {
public:
    int minimumDistance(string word) {
        
        int n = word.size();
        int dp[n][26][26];
        memset(dp, 0x3f, sizeof(dp));
        dp[0][0][0] = 0;
        for (int i = 1; i < n; ++i) {
            int x1 = word[i - 1] - 'A';
            int x2 = word[i] - 'A';
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    dp[i][x2][j] = min(dp[i][x2][j], dp[i - 1][x1][k] + dist(x1, x2));
                    dp[i][j][x2] = min(dp[i][j][x2], dp[i - 1][k][x1] + dist(x1, x2));
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                ans = min(ans, dp[n - 1][i][j]);
            }
        }
        return ans;
    }
};