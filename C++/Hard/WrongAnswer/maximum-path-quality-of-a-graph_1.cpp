class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, -1));
        return dfs(g, dp, values, 0, maxTime);
    }
    int dfs(vector<vector<pair<int, int>>>& g, vector<vector<int>>& dp, vector<int>& values, int u, int t) {
        if (dp[u][t] != -1) return dp[u][t];
        int ans = 0;
        for (auto& p : g[u]) {
            int v = p.first, w = p.second;
            if (t >= w) ans = max(ans, dfs(g, dp, values, v, t - w));
        }
        return dp[u][t] = ans + values[u];
    }
};