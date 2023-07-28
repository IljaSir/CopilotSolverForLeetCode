class Solution {
public:
    int minimumDistance(string word) {
        
        int n = word.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(27, vector<int>(27, 10000)));
        int dist[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = abs(i / 6 - j / 6) + abs(i % 6 - j % 6);
            }
        }
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[0][i][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            int cur = word[i] - 'A';
            int pre = word[i - 1] - 'A';
            for (int j = 0; j < 27; j++) {
                for (int k = 0; k < 27; k++) {
                    if (j < 26) {
                        dp[i][cur][k] = min(dp[i][cur][k], dp[i - 1][j][k] + dist[j][cur]);
                    }
                    if (k < 26) {
                        dp[i][j][cur] = min(dp[i][j][cur], dp[i - 1][j][k] + dist[k][cur]);
                    }
                }
            }
        }
        int ans = 10000;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ans = min(ans, dp[n - 1][i][j]);
            }
        }
        return ans;
    }
};