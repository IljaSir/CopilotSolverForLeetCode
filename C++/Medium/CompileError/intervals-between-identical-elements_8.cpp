class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        const int n = arr.size();
        vector<long long> ans(n, 0);
        vector<vector<int>> pos(100001);
        for (int i = 0; i < n; ++i) {
            pos[arr[i]].push_back(i);
        }
        for (const auto& p : pos) {
            int m = p.size();
            if (m == 1) continue;
            for (int i = 0; i < m; ++i) {
                ans[p[i]] += (i == 0 ? 0 : p[i] - p[i - 1]) * (m - i);
            }
            for (int i = m - 1; i >= 0; --i) {
                ans[p[i]] += (i == m - 1 ? 0 : p[i + 1] - p[i]) * (i + 1);
            }
        }
        return ans;
    }
    vector<long long> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> g(n);
        for (const auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> sz(n, 1);
        vector<int> dep(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v : g[u]) {
                if (v == p) continue;
                dep[v] = dep[u] + 1;
                dfs(v, u);
                sz[u] += sz[v];
            }
        };
        dfs(0, -1);
        vector<long long> ans(n, 0);
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v : g[u]) {
                if (v == p) continue;
                ans[v] = ans[u] + n - sz[v] - sz[v];
                dfs2(v, u);
            }
        };
        dfs2(0, -1);
        vector<long long> ans2 = getDistances(arr);
        for (int i = 0; i < n; ++i) {
            ans[i] += ans2[i];
        }
        return ans;
    }
};