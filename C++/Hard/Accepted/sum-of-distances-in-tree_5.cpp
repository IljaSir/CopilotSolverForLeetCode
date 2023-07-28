class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> res(n, 0), cnt(n, 1);
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v : adj[u]) {
                if (v == p) continue;
                dfs(v, u);
                cnt[u] += cnt[v];
                res[u] += res[v] + cnt[v];
            }
        };
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v : adj[u]) {
                if (v == p) continue;
                res[v] = res[u] - cnt[v] + n - cnt[v];
                dfs2(v, u);
            }
        };
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }
};