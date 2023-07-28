class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> adj(n + 1, vector<int>(n + 1, 0));
        for (auto r : roads) {
            if (adj[r[0]][r[1]] == 0 || adj[r[0]][r[1]] > r[2]) {
                adj[r[0]][r[1]] = r[2];
                adj[r[1]][r[0]] = r[2];
            }
        }
        vector<int> dist(n + 1, INT_MAX);
        vector<bool> visited(n + 1, false);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            int minDist = INT_MAX;
            int minIdx = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minIdx = j;
                    minDist = dist[j];
                }
            }
            if (minIdx == -1) {
                break;
            }
            visited[minIdx] = true;
            for (int j = 1; j <= n; j++) {
                if (adj[minIdx][j] != 0 && !visited[j] && dist[j] > adj[minIdx][j]) {
                    dist[j] = adj[minIdx][j];
                }
            }
        }
        return dist[n];
    }
};