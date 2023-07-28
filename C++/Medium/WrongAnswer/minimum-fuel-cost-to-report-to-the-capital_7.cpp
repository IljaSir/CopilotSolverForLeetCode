class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> g(n, vector<int>());
        for (auto& e: roads) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> sub(n, 1);
        vector<int> f(n, 0);
        vector<int> dp(n, 0);
        vector<int> g1(n, 0);
        vector<int> g2(n, 0);
        vector<int> g3(n, 0);
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v: g[u]) {
                if (v != p) {
                    dfs(v, u);
                    sub[u] += sub[v];
                    f[u] += f[v] + sub[v];
                }
            }
        };
        dfs(0, -1);
        function<void(int, int, int)> dfs2 = [&](int u, int p, int s) {
            dp[u] = s;
            for (int v: g[u]) {
                if (v != p) {
                    dfs2(v, u, s + f[0] - f[v] - sub[v] + n - sub[v]);
                }
            }
        };
        dfs2(0, -1, 0);
        function<void(int, int)> dfs3 = [&](int u, int p) {
            for (int v: g[u]) {
                if (v != p) {
                    g1[v] = g1[u] + f[u] - f[v] - sub[v] + n - sub[v];
                    g2[v] = min(g2[u], g1[v]);
                    g3[v] = min(g3[u], g1[v]);
                    dfs3(v, u);
                }
            }
        };
        dfs3(0, -1);
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += min({dp[i], g1[i], g2[i], g3[i]});
        }
        return ans / 2;
    }
};