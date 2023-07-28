class Solution {
public:
    double getProbability(vector<int>& balls) {
        
        int n = balls.size();
        int m = 0;
        for (int i = 0; i < n; i++) {
            m += balls[i];
        }
        m /= 2;
        vector<vector<double>> dp(m + 1, vector<double>(1 << n, 0));
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int mask = (1 << n) - 1; mask >= 0; mask--) {
                    if (dp[j][mask] == 0) continue;
                    for (int k = 0; k < balls[i]; k++) {
                        int newMask = mask | (1 << i);
                        dp[j + 1][newMask] += dp[j][mask] / C(balls[i], k + 1);
                    }
                }
            }
        }
        double ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (__builtin_popcount(mask) != n / 2) continue;
            ans += dp[m][mask] * dp[m][mask ^ ((1 << n) - 1)];
        }
        return ans;
    }
};