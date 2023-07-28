class Solution {
public:
    int maxStarSum(vector<int>& vals, vector<vector<int>>& edges, int k) {
        
        int n = vals.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, 0);
        vector<int> st(n, 0);
        vector<int> sz(n, 0);
        vector<int> ms(n, 0);
        vector<int> ms2(n, 0);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            ms[u] = vals[u];
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u);
                sz[u] += sz[v];
                ms[u] = max(ms[u], ms[v]);
                if (ms[v] > ms[st[u]]) {
                    st[u] = v;
                }
            }
        };
        function<void(int, int, bool)> dfs2 = [&](int u, int p, bool keep) {
            for (int v : g[u]) {
                if (v == p || v == st[u]) continue;
                dfs2(v, u, false);
            }
            if (st[u] != 0) {
                dfs2(st[u], u, true);
            }
            dp[u] = 0;
            for (int v : g[u]) {
                if (v == p || v == st[u]) continue;
                for (int i = 0; i < sz[v]; i++) {
                    dp[u] += vals[v];
                }
            }
            dp[u] += vals[u];
            if (keep) {
                ms2[u] = ms[u];
            } else {
                ms2[u] = vals[u];
            }
            for (int v : g[u]) {
                if (v == p || v == st[u]) continue;
                ms2[u] = max(ms2[u], ms2[v]);
            }
        };
        dfs(0, -1);
        dfs2(0, -1, false);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sz[i] <= k + 1) {
                ans = max(ans, dp[i]);
            }
            if (sz
    }
};