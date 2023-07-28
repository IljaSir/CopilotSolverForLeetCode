class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<int> deg(n + 1, 0);
        for (auto& e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
        }
        int odd = 0;
        for (int i = 1; i <= n; i++) {
            if (deg[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd % 2 == 1) {
            return false;
        }
        vector<unordered_set<int>> g(n + 1);
        for (auto& e : edges) {
            g[e[0]].insert(e[1]);
            g[e[1]].insert(e[0]);
        }
        vector<bool> vis(n + 1, false);
        for (int i = 1; i <= n; i++) {
            if (vis[i] || deg[i] % 2 == 0) {
                continue;
            }
            queue<int> q;
            q.push(i);
            vis[i] = true;
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v : g[u]) {
                    if (vis[v] || deg[v] % 2 == 0) {
                        continue;
                    }
                    vis[v] = true;
                    q.push(v);
                }
            }
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (vis[j]) {
                    cnt++;
                }
            }
            if (cnt % 2 == 1) {
                return false;
            }
        }
        return true;
    }
};