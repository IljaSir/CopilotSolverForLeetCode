class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0] - 1].push_back(e[1] - 1);
            g[e[1] - 1].push_back(e[0] - 1);
        }
        vector<int> d(n);
        for (int i = 0; i < n; ++i) {
            d[i] = g[i].size();
        }
        vector<int> vis(n);
        function<void(int)> dfs = [&](int u) {
            vis[u] = 1;
            for (auto& v : g[u]) {
                if (!vis[v]) {
                    dfs(v);
                }
            }
        };
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                ++cnt;
                dfs(i);
            }
        }
        if (cnt > 1) {
            return false;
        }
        int odd = 0;
        for (int i = 0; i < n; ++i) {
            if (d[i] % 2) {
                ++odd;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd != 2) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (d[i] % 2) {
                for (auto& v : g[i]) {
                    if (d[v] % 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};