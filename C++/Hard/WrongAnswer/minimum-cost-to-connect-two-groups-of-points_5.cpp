class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int m = cost.size(), n = cost[0].size();
        int dp[1 << m][n];
        memset(dp, 0x3f, sizeof(dp));
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[1 << i][j] = cost[i][j];
            }
        }
        for (int s = 1; s < (1 << m); s++) {
            int cnt = __builtin_popcount(s);
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (s >> i & 1) {
                        dp[s][j] = min(dp[s][j], dp[s ^ (1 << i)][j] + cost[i][j]);
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (!(s >> i & 1)) {
                        dp[s | (1 << i)][j] = min(dp[s | (1 << i)][j], dp[s][j]);
                    }
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int s = 0; s < (1 << m); s++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (s >> i & 1) {
                    sum += *min_element(cost[i].begin(), cost[i].end());
                }
            }
            for (int j = 0; j < n; j++) {
                ans = min(ans, sum + dp[s][j]);
            }
        }
        return ans;
    }
};