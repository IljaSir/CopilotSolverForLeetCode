class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        int dp[5001][6][16] = {0};
        int mod = 1e9 + 7;
        for (int i = 0; i < 6; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (j == l) {
                            if (k + 1 <= rollMax[j]) {
                                dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][l][k]) % mod;
                            }
                        } else {
                            dp[i][j][1] = (dp[i][j][1] + dp[i - 1][l][k]) % mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= rollMax[i]; j++) {
                res = (res + dp[n][i][j]) % mod;
            }
        }
        return res;
    }
};