class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        // vector<vector<int>> dist(n, vector<int>(n, 0));
        vector<int> dist(n, INT_MAX);
        vector<bool> visited(n, false);
        int res = 0;
        dist[0] = 0;
        for(int i = 0; i < n; i++){
            int u = -1;
            for(int v = 0; v < n; v++){
                if(!visited[v] && (u == -1 || dist[v] < dist[u])){
                    u = v;
                }
            }
            visited[u] = true;
            res += dist[u];
            for(int v = 0; v < n; v++){
                if(!visited[v]){
                    dist[v] = min(dist[v], abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1]));
                }
            }
        }
        return res;
    }
};