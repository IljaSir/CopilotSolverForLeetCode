class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        vector<vector<int>> edges(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                edges[i][j] = edges[j][i] = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
            }
        }
        vector<int> dist(n, INT_MAX), visited(n);
        dist[0] = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            visited[t] = 1;
            res += dist[t];
            for (int j = 0; j < n; ++j) {
                dist[j] = min(dist[j], edges[t][j]);
            }
        }
        return res;
    }
};