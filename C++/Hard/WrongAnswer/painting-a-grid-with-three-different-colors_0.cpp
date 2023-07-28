class Solution {
public:
    int colorTheGrid(int m, int n) {
        
        vector<vector<int>> dp(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (j != k) {
                        dp[j][i] = (dp[j][i] + dp[k][i - 1]) % 1000000007;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            res = (res + dp[i][n - 1]) % 1000000007;
        }
        return res;
    }
};