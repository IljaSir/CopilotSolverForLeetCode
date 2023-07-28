class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> g(n + 1, vector<int>(n + 1, 0));
        for (auto& r : roads) {
            g[r[0]][r[1]] = g[r[1]][r[0]] = r[2];
        }
        vector<int> dist(n + 1, 0x3f3f3f3f);
        vector<bool> vis(n + 1, false);
        dist[1] = 0;
        for (int i = 1; i <= n; ++i) {
            int u = -1;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            vis[u] = true;
            for (int v = 1; v <= n; ++v) {
                if (g[u][v]) {
                    dist[v] = min(dist[v], max(dist[u], g[u][v]));
                }
            }
        }
        return dist[n];
    }
};