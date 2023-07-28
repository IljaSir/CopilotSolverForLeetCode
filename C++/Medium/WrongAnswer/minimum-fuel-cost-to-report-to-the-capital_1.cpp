class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> g(n);
        for (auto& r : roads) {
            g[r[0]].push_back(r[1]);
            g[r[1]].push_back(r[0]);
        }
        vector<int> sz(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u);
                sz[u] += sz[v];
            }
        };
        dfs(0, -1);
        int m = seats;
        vector<vector<long long>> f(n, vector<long long>(m + 1));
        function<void(int, int)> solve = [&](int u, int p) {
            for (int v : g[u]) {
                if (v == p) continue;
                solve(v, u);
                for (int i = m; i >= 0; i--) {
                    for (int j = 0; j <= i; j++) {
                        f[u][i] = min(f[u][i], f[u][i - j] + f[v][j]);
                    }
                }
            }
            f[u][1] = sz[u] - 1;
        };
        solve(0, -1);
        long long ans = 1e18;
        for (int i = 0; i <= m; i++) ans = min(ans, f[0][i]);
        return ans;
    }
};