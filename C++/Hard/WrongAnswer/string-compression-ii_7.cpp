class Solution {
public:
    int getLengthOfOptimalCompression(string s, int k) {
        
        int n = s.size();
        int dp[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = INT_MAX;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == INT_MAX) continue;
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1);
                if (j < n) dp[i + 1][j + 1] = min(dp[i + 1][j + 1], dp[i][j]);
            }
            int p = i + 1;
            while (p < n && s[p] == s[i]) p++;
            int l = p - i;
            if (l < 10) {
                for (int j = 0; j <= n; j++) {
                    if (dp[i][j] == INT_MAX) continue;
                    dp[p][j + l - 1] = min(dp[p][j + l - 1], dp[i][j] + 1);
                }
            } else if (l < 100) {
                for (int j = 0; j <= n; j++) {
                    if (dp[i][j] == INT_MAX) continue;
                    dp[p][j + l - 2] = min(dp[p][j + l - 2], dp[i][j] + 2);
                }
            } else {
                for (int j = 0; j <= n; j++) {
                    if (dp[i][j] == INT_MAX) continue;
                    dp[p][j + l - 3] = min(dp[p][j + l - 3], dp[i][j] + 3);
                }
            }
            i = p - 1;
        }
        int ans = INT_MAX;
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] <= k) ans = min(ans, i);
        }
        return ans;
    }
};