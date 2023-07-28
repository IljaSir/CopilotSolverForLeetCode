class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        vector<vector<int>> dist(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = dist[j][i] = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
            }
        }
        vector<int> minDist(n, INT_MAX);
        vector<bool> visited(n, false);
        int res = 0;
        minDist[0] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1, minD = INT_MAX;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < minD) {
                    minD = minDist[j];
                    u = j;
                }
            }
            if (u == -1) return -1;
            visited[u] = true;
            res += minD;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[u][v] < minDist[v]) {
                    minDist[v] = dist[u][v];
                }
            }
        }
        return res;
    }
};