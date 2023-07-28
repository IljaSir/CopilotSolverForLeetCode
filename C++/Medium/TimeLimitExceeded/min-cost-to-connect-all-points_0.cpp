class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        vector<vector<int>> dist(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dist[i][j] = dist[j][i] = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
            }
        }
        int res = 0;
        vector<int> seen(n);
        seen[0] = 1;
        for (int i = 0; i < n - 1; ++i) {
            int x = -1, y = -1;
            for (int j = 0; j < n; ++j) {
                if (seen[j]) {
                    for (int k = 0; k < n; ++k) {
                        if (!seen[k] && (x == -1 || dist[j][k] < dist[x][y])) {
                            x = j;
                            y = k;
                        }
                    }
                }
            }
            res += dist[x][y];
            seen[y] = 1;
        }
        return res;
    }
};