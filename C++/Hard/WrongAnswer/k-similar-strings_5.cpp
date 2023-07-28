class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        int n = s1.size();
        vector<vector<int>> next(n, vector<int>(n, n));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s1[i] == s2[j]) {
                    next[i][j] = j;
                }
            }
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    next[j][k] = min(next[j][k], next[j][i]);
                }
            }
        }
        vector<vector<int>> dp(n, vector<int>(1 << n, n));
        dp[0][1] = 0;
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    for (int k = 0; k < n; ++k) {
                        if (!(i & (1 << k))) {
                            int t = next[j][k];
                            if (t < n) {
                                dp[k][i | (1 << k)] = min(dp[k][i | (1 << k)], dp[j][i] + (t != k));
                            }
                        }
                    }
                }
            }
        }
        return dp[n - 1][(1 << n) - 1];
    }
};