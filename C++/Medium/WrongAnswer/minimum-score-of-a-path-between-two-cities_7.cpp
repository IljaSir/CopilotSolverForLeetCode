class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        const int INF = 0x3f3f3f3f;
        vector<vector<int>> dist(n, vector<int>(n, INF));
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (auto e : roads) {
            int u = e[0] - 1, v = e[1] - 1, w = e[2];
            dist[u][v] = dist[v][u] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = min(dist[i][j], max(dist[i][k], dist[k][j]));
                }
            }
        }
        return dist[0][n - 1];
    }
};