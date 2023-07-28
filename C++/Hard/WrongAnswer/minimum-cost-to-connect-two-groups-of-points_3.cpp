class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int n = cost.size(), m = cost[0].size();
        vector<int> dp(1 << m, 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            vector<int> t(1 << m, 1e9);
            for (int j = 0; j < (1 << m); j++) {
                for (int k = 0; k < m; k++) {
                    if (j & (1 << k)) {
                        t[j] = min(t[j], dp[j ^ (1 << k)] + cost[i][k]);
                    }
                }
            }
            dp = t;
        }
        vector<int> sum(1 << m);
        for (int i = 0; i < (1 << m); i++) {
            for (int j = 0; j < m; j++) {
                if (i & (1 << j)) {
                    sum[i] += cost[n - 1][j];
                }
            }
        }
        for (int i = 0; i < (1 << m); i++) {
            for (int j = 0; j < (1 << m); j++) {
                dp[i | j] = min(dp[i | j], dp[i] + sum[j]);
            }
        }
        return dp[(1 << m) - 1];
    }
};