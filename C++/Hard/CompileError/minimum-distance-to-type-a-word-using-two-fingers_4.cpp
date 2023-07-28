class Solution {
public:
    int minimumDistance(string word) {
        
        int n = word.size();
        int dp[26][26][n];
        memset(dp, 0x3f, sizeof(dp));
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                dp[i][j][0] = 0;
            }
        }
        for (int i = 1; i < n; ++i) {
            int x = word[i] - 'A';
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    dp[j][x][i] = min(dp[j][x][i], dp[j][k][i-1] + dist(k, x));
                    dp[x][k][i] = min(dp[x][k][i], dp[j][k][i-1] + dist(j, x));
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                ans = min(ans, dp[i][j][n-1]);
            }
        }
        return ans;
    }
};