class Solution {
public:
    int minCut(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]);
            }
        }
        vector<int> f(n, INT_MAX);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        f[i] = min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
};