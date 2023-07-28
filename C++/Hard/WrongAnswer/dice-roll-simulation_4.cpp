class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        if (n == 0) return 0;
        if (n == 1) return 6;
        if (n == 2) return 6 * 5 + 1;
        if (n == 3) return 6 * 5 * 4 + 6 * 5 + 1;
        int dp[5001][6][16] = {0};
        int mod = 1000000007;
        for (int i = 1; i <= 6; i++) {
            dp[1][i - 1][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= 15; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (j == l) {
                            if (k < rollMax[j]) {
                                dp[i][j][k + 1] += dp[i - 1][j][k];
                                dp[i][j][k + 1] %= mod;
                            }
                        } else {
                            dp[i][j][1] += dp[i - 1][l][k];
                            dp[i][j][1] %= mod;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= 15; j++) {
                result += dp[n][i][j];
                result %= mod;
            }
        }
        return result;
    }
};