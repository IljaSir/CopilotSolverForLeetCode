class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n);
        for (auto& e: edges) {
            g[e[0]-1].push_back(e[1]-1);
            g[e[1]-1].push_back(e[0]-1);
        }
        vector<int> d(n, 0);
        for (int i = 0; i < n; ++i) {
            d[i] = g[i].size();
        }
        vector<bool> vis(n, false);
        int odd = 0;
        for (int i = 0; i < n; ++i) {
            if (d[i] % 2 == 1) {
                ++odd;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd % 2 == 1) {
            return false;
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (d[i] % 2 == 1) {
                q.push(i);
                vis[i] = true;
                break;
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v: g[u]) {
                if (vis[v]) {
                    continue;
                }
                if (d[v] % 2 == 1) {
                    vis[v] = true;
                    q.push(v);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!vis[i] && d[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }
};