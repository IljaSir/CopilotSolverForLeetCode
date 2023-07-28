class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        int n = s1.size();
        vector<vector<int>> dp(1<<n, vector<int>(n, n));
        for (int i = 0; i < n; i++) {
            if (s1[i] == s2[i]) {
                dp[1<<i][i] = 0;
            }
        }
        for (int mask = 1; mask < (1<<n); mask++) {
            int x = -1, y = -1;
            for (int i = 0; i < n; i++) {
                if (!(mask & (1<<i))) {
                    continue;
                }
                if (x == -1) {
                    x = i;
                } else {
                    y = i;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (s1[x] != s2[i] || s1[y] != s2[i]) {
                    continue;
                }
                dp[mask][i] = min(dp[mask][i], dp[mask^(1<<x)^(1<<y)][y] + 1);
            }
            for (int i = 0; i < n; i++) {
                if (s1[i] != s2[i]) {
                    continue;
                }
                dp[mask][i] = min(dp[mask][i], dp[mask^(1<<i)][i]);
            }
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            ans = min(ans, dp[(1<<n)-1][i]);
        }
        return ans;
    }
};