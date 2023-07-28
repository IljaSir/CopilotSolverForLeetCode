class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<vector<int>> g(n);
        for (auto& e: richer) {
            g[e[1]].push_back(e[0]);
        }
        vector<int> ans(n, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, g, ans, quiet);
        }
        return ans;
    }
    int dfs(int u, vector<vector<int>>& g, vector<int>& ans, vector<int>& quiet) {
        if (ans[u] >= 0) return ans[u];
        ans[u] = u;
        for (auto& v: g[u]) {
            int x = dfs(v, g, ans, quiet);
            if (quiet[x] < quiet[ans[u]]) ans[u] = x;
        }
        return ans[u];
    }
};