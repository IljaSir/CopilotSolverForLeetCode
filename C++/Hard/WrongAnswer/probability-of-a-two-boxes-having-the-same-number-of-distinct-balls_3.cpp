class Solution {
public:
    double getProbability(vector<int>& balls) {
        
        int n = balls.size();
        int m = balls[0];
        for (int i = 1; i < n; i++) {
            m = max(m, balls[i]);
        }
        vector<vector<long long>> dp(1 << n, vector<long long>(m + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (i & (1 << k)) {
                        continue;
                    }
                    for (int t = 1; t <= balls[k]; t++) {
                        if (j + t > m) {
                            break;
                        }
                        dp[i | (1 << k)][j + t] += dp[i][j];
                    }
                }
            }
        }
        long long total = 0;
        for (int i = 0; i <= m; i++) {
            total += dp[(1 << n) - 1][i];
        }
        long long ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == j) {
                    ans += dp[(1 << n) - 1][i] * dp[(1 << n) - 1][j];
                }
            }
        }
        return (double)ans / total;
    }
};