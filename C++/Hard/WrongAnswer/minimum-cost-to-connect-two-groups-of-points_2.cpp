class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int n = cost.size(), m = cost[0].size();
        vector<vector<int>> dp(n, vector<int>(1 << m, INT_MAX / 2));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][1 << j] = cost[i][j];
            }
        }
        for (int i = 1; i < (1 << m); ++i) {
            int cnt = __builtin_popcount(i);
            if (cnt > n) continue;
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if ((i >> k) & 1) {
                        dp[j][i] = min(dp[j][i], dp[j][i ^ (1 << k)] + cost[j][k]);
                    }
                }
            }
        }
        vector<vector<int>> f(n + 1, vector<int>(1 << m, INT_MAX / 2));
        f[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (1 << m); ++j) {
                f[i + 1][j] = min(f[i + 1][j], f[i][j]);
                for (int k = 0; k < m; ++k) {
                    f[i + 1][j | (1 << k)] = min(f[i + 1][j | (1 << k)], f[i][j] + cost[i][k]);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < (1 << m); ++i) {
            ans = min(ans, f[n][i] + dp[n - 1][((1 << m) - 1) ^ i]);
        }
        return ans;
    }
};