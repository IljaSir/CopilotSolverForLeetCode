class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        queue<tuple<int, int, int>> q;
        vector<vector<int>> vis(n, vector<int>(1<<n));
        for (int i = 0; i < n; i++) {
            q.emplace(i, 1<<i, 0);
            vis[i][1<<i] = true;
        }
        while (!q.empty()) {
            auto [u, mask, d] = q.front();
            q.pop();
            if (mask == (1<<n) - 1) return d;
            for (int v : graph[u]) {
                int mask2 = mask | (1<<v);
                if (!vis[v][mask2]) {
                    vis[v][mask2] = true;
                    q.emplace(v, mask2, d + 1);
                }
            }
        }
        return 0;
    }
};