class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        const int MOD = 1e9 + 7;
        // dp[i][j] = {ways: int, time: int}
        vector<vector<pair<int, int>>> dp(n, vector<pair<int, int>>(n, {0, 0}));
        for (auto& r : roads) {
            int u = r[0], v = r[1], t = r[2];
            dp[u][v] = {1, t};
            dp[v][u] = {1, t};
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || dp[i][k].second == 0 || dp[k][j].second == 0) {
                        continue;
                    }
                    int time = dp[i][k].second + dp[k][j].second;
                    if (dp[i][j].second == 0 || time < dp[i][j].second) {
                        dp[i][j].second = time;
                        dp[i][j].first = dp[i][k].first * dp[k][j].first;
                    } else if (time == dp[i][j].second) {
                        dp[i][j].first = (dp[i][j].first + dp[i][k].first * dp[k][j].first) % MOD;
                    }
                }
            }
        }
        return dp[0][n - 1].first;
    }
};