class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        vector<vector<int>> graph(n+1, vector<int>(n+1, -1));
        for (auto time : times) {
            graph[time[0]][time[1]] = time[2];
        }
        vector<int> dist(n+1, INT_MAX);
        dist[k] = 0;
        vector<bool> visited(n+1, false);
        for (int i = 1; i <= n; i++) {
            int minDist = INT_MAX;
            int minIndex = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIndex = j;
                }
            }
         
        return res;
    }
};