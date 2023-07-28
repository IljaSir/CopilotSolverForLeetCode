class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        vector<vector<int>> dist(n, vector<int>(n));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = dist[j][i] = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
            }
        }
        vector<int> minDist(n, INT_MAX);
        vector<bool> visited(n);
        minDist[0] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[u] > minDist[j])) {
                    u = j;
                }
            }
            visited[u] = true;
            res += minDist[u];
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    minDist[v] = min(minDist[v], dist[u][v]);
                }
            }
        }
        return res;
    }
};