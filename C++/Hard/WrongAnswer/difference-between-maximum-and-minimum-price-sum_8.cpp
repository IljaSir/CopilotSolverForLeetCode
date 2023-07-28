class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
        vector<int> adj[n];
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, 0);
        vector<int> sz(n, 1);
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v: adj[u]) {
                if (v == p) continue;
                dfs(v, u);
                dp[u] += dp[v] + sz[v];
                sz[u] += sz[v];
            }
        };
        dfs(0, -1);
        vector<int> dp2(n, 0);
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v: adj[u]) {
                if (v == p) continue;
                dp2[v] = dp2[u] + (dp[0] - dp[v] - sz[v]) + (n - sz[v]);
                dfs2(v, u);
            }
        };
        dfs2(0, -1);
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, 1LL * dp[i] * price[i] + 1LL * dp2[i] * price[i]);
        }
        return res;
    }
};