class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> raph(n);
        for (auto &dge
        vector<int> res(n);
        vector<int> count(n);
        function<void(int, int)> dfs1 = [&](int u, int p) {
            count[u] = 1;
            for (int v : adj[u]) {
                if (v != p) {
                    dfs1(v, u);
                    count[u] += count[v];
                    res[u] += res[v] + count[v];
                }
            }
        };
        dfs1(0, -1);
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v : adj[u]) {
                if (v != p) {
                    res[v] = res[u] - count[v] + n - count[v];
                    dfs2(v, u);
                }
            }
        };
        d
    }
};