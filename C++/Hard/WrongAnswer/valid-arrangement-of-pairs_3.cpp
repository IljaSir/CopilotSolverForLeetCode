class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        vector<vector<int>> ans;
        vector<vector<int>> g(100001);
        for (auto& p : pairs) {
            g[p[0]].push_back(p[1]);
            g[p[1]].push_back(p[0]);
        }
        vector<int> vis(100001, 0);
        function<void(int)> dfs = [&](int u) {
            vis[u] = 1;
            for (int v : g[u]) {
                if (!vis[v]) {
                    ans.push_back({u, v});
                    dfs(v);
                }
            }
        };
        dfs(pairs[0][0]);
        return ans;
    }
};