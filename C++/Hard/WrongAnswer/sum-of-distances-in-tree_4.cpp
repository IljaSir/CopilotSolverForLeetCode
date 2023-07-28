class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n);
        for (auto &e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> sz(n), dist(n);
        dfs(g, sz, dist, 0, -1);
        dfs2(g, sz, dist, 0, -1);
        return dist;
    }
    void dfs(vector<vector<int>> &g, vector<int> &sz, vector<int> &dist, int u, int p) {
        sz[u] = 1;
        for (int v: g[u]) {
            if (v == p) continue;
            dist[v] = dist[u] + 1;
            dfs(g, sz, dist, v, u);
            sz[u] += sz[v];
        }
    }
    void dfs2(vector<vector<int>> &g, vector<int> &sz, vector<int> &dist, int u, int p) {
        for (int v: g[u]) {
            if (v == p) continue;
            dist[v] = dist[u] - sz[v] + sz.size() - sz[v];
            dfs2(g, sz, dist, v, u);
        }
    }
};