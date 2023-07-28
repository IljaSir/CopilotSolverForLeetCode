class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                dist[i][j] = 1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        vector<vector<int>> dp(1 << n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if (!(mask & (1 << i))) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (mask & (1 << j)) {
                        continue;
                    }
                    dp[mask | (1 << j)][j] = min(dp[mask | (1 << j)][j], dp[mask][i] + dist[i][j]);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            ans = min(ans, dp[(1 << n) - 1][i]);
        }
        return ans;
    }
};