class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> g(n);
        for (auto& e : roads) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<long long> dp(n);
        vector<int> sz(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u);
                sz[u] += sz[v];
                dp[u] += dp[v];
            }
            dp[u] += sz[u] - 1;
        };
        dfs(0, -1);
        vector<long long> dp2(n);
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v : g[u]) {
                if (v == p) continue;
                dp2[v] = dp2[u] + n - 2 * sz[v];
                dfs2(v, u);
            }
        };
        dfs2(0, -1);
        long long ans = 1e18;
        for (int i = 0; i < n; ++i) {
            ans = min(ans, dp[i] + dp2[i] - (seats - 1) * (n - 1));
        }
        return ans;
    }
};