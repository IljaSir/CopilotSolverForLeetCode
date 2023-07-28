class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        if (maxMove == 0) {
            return 0;
        }
        vector<vector<long>> dp(m, vector<long>(n, 0));
        dp[startRow][startColumn] = 1;
        vector<vector<long>> dp2(m, vector<long>(n, 0));
        long res = 0;
        long mod = 1000000007;
        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    long tmp = 0;
                    if (j == 0) {
                        tmp += 1;
                    } else {
                        tmp += dp[j - 1][k];
                    }
                    if (j == m - 1) {
                        tmp += 1;
                    } else {
                        tmp += dp[j + 1][k];
                    }
                    if (k == 0) {
                        tmp += 1;
                    } else {
                        tmp += dp[j][k - 1];
                    }
                    if (k == n - 1) {
                        tmp += 1;
                    } else {
                        tmp += dp[j][k + 1];
                    }
                    tmp %= mod;
                    dp2[j][k] = tmp;
                }
            }
            dp = dp2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[i][j];
                res %= mod;
            }
        }
        return res;
    }
};