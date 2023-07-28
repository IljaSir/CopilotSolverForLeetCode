class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> g(n, vector<pair<int, int>>());
        for (auto& e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, -1));
        int ans = 0;
        function<int(int, int)> dfs = [&](int u, int t) {
            if (dp[u][t] != -1) return dp[u][t];
            dp[u][t] = values[u];
            for (auto [v, w] : g[u]) {
                if (t - w >= 0) {
                    dp[u][t] = max(dp[u][t], dfs(v, t - w) + values[u]);
                }
            }
            return dp[u][t];
        };
        for (int i = 0; i < n; ++i) {
            ans = max(ans, dfs(i, maxTime));
        }
        return ans;
    }
};