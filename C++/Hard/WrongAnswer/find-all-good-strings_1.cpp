class Solution {
public:
    int findGoodStrings(int n, string s1, string s2, string evil) {
        
        int i, j, k;
        int m = evil.size();
        vector<vector<int>> next(m+1, vector<int>(26, -1));
        for (i = 0; i < 26; ++i) {
            next[0][i] = 0;
        }
        for (i = 0; i < m; ++i) {
            for (j = 0; j < 26; ++j) {
                next[i+1][j] = next[next[i][j]][j];
            }
            next[i+1][evil[i]-'a'] = i+1;
        }
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        dp[0][0] = 1;
        for (i = 0; i < n; ++i) {
            for (j = 0; j < m; ++j) {
                if (dp[i][j] == 0) continue;
                for (k = (i == 0 ? s1[i]-'a'+1 : 0); k <= (i == n-1 ? s2[i]-'a'-1 : 25); ++k) {
                    dp[i+1][next[j][k]] = (dp[i+1][next[j][k]] + dp[i][j]) % 1000000007;
                }
            }
        }
        int ans = 0;
        for (i = 0; i < m; ++i) {
            ans = (ans + dp[n][i]) % 1000000007;
        }
        for (i = 0; i < n; ++i) {
            for (j = (i == 0 ? s1[i]-'a' : 0); j <= (i == n-1 ? s2[i]-'a' : 25); ++j) {
                if (next[m][j] == m) {
                    ans = (ans + dp[i][m]) % 1000000007;
                }
            }
        }
        return ans;
    }
};