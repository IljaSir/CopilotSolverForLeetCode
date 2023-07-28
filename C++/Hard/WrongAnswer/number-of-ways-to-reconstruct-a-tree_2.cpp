class Solution {
public:
    int checkWays(vector<vector<int>>& pairs) {
        
        int n = pairs.size();
        if (n == 1) return 1;
        vector<vector<int>> g(501);
        for (auto &pair : pairs) {
            g[pair[0]].push_back(pair[1]);
            g[pair[1]].push_back(pair[0]);
        }
        vector<int> vis(501, 0);
        int ans = 0;
        for (int i = 1; i <= 500; ++i) {
            if (g[i].size() == 0) continue;
            if (vis[i]) continue;
            ++ans;
            if (ans > 1) return 2;
            dfs(g, i, vis);
        }
        return ans;
    }
    void dfs(vector<vector<int>> &g, int u, vector<int> &vis) {
        vis[u] = 1;
        for (auto &v : g[u]) {
            if (vis[v]) continue;
            dfs(g, v, vis);
        }
    }
};