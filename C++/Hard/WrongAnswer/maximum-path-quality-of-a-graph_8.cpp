class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<vector<int>>> g(n);
        for (auto& e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].push_back({v, w});
            g[v].push_back({u, w});
        }
        
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, -1));
        dp[0][0] = values[0];
        for (int t = 0; t <= maxTime; ++t) {
            for (int u = 0; u < n; ++u) {
                if (dp[u][t] == -1) continue;
                for (auto& e : g[u]) {
                    int v = e[0], w = e[1];
                    if (t + w > maxTime) continue;
                    dp[v][t + w] = max(dp[v][t + w], dp[u][t] + values[v]);
                }
            }
        }
        
        int ans = 0;
        for (int t = 0; t <= maxTime; ++t) {
            ans = max(ans, dp[0][t]);
        }
        return ans;
    }
};