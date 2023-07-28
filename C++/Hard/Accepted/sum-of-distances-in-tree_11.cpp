class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto &e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> count(n, 1), res(n, 0);
        function<void(int, int)> dfs1 = [&](int u, int p) {
            for (int v : adj[u]) {
                if (v == p) continue;
                dfs1(v, u);
                count[u] += count[v];
                res[u] += res[v] + count[v];
            }
        };
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v : adj[u]) {
                if (v == p) continue;
                res[v] = res[u] - count[v] + n - count[v];
                dfs2(v, u);
            }
        };
        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }
};