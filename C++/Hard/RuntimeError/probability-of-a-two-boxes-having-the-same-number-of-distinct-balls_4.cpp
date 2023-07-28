class Solution {
public:
    double getProbability(vector<int>& balls) {
        
        int n = balls.size();
        int m = balls.size() / 2;
        vector<int> cnt(1 << n);
        vector<int> sum(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    cnt[i]++;
                    sum[i] += balls[j];
                }
            }
        }
        vector<vector<double>> dp(1 << n, vector<double>(m + 1));
        dp[0][0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = i + 1; k < (1 << n); k++) {
                    if ((i & k) == 0 && cnt[i] == cnt[k] && sum[i] == sum[k]) {
                        dp[k][j + 1] += dp[i][j] / __builtin_popcount(k);
                    }
                }
            }
        }
        return dp[(1 << n) - 1][m];
    }
};