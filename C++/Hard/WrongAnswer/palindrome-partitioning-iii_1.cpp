class Solution {
public:
    int palindromePartition(string s, int k) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i >= j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (s[i] != s[j]) {
                        dp[i][j]++;
                    }
                }
            }
        }
        vector<vector<int>> f(n + 1, vector<int>(k + 1, INT_MAX / 2));
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                for (int p = 0; p < i; ++p) {
                    f[i][j] = min(f[i][j], f[p][j - 1] + dp[p][i - 1]);
                }
            }
        }
        return f[n][k];
    }
};