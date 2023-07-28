class Solution {
public:
    int numOfArrays(int n, int m, int k) {
        
        if (k > m) return 0;
        if (n == 1) return k;
        if (k == 1) return pow(m, n);
        int dp[n][m][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i][j][l] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                dp[1][i][j] = pow(m, j + 1);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    for (int x = 0; x < m; x++) {
                        if (x > j) {
                            dp[i][j][l] += dp[i - 1][x][l - 1];
                        } else {
                            dp[i][j][l] += dp[i - 1][x][l];
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += dp[n - 1][i][k - 1];
        }
        return sum;
    }
};