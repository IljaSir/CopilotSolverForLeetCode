class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        vector<vector<int>> graph(n, vector<int>(n));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[i][j] = graph[j][i] = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
            }
        }
        vector<int> dist(n, INT_MAX);
        vector<bool> visited(n);
        dist[0] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            res += dist[u];
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    dist[v] = min(dist[v], graph[u][v]);
                }
            }
        }
        return res;
    }
};