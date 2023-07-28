class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n + 1);
        vector<int> deg(n + 1);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
            ++deg[e[0]];
            ++deg[e[1]];
        }
        for (int i = 1; i <= n; ++i) {
            if (deg[i] % 2 != 0) {
                g[0].push_back(i);
                g[i].push_back(0);
                ++deg[0];
            }
        }
        queue<int> q;
        q.push(0);
        vector<bool> visited(n + 1);
        visited[0] = true;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : g[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.push(v);
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
};