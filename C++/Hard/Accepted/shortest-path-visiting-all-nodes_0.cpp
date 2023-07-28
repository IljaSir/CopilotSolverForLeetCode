class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> dist(n, vector<int>(1 << n, INT_MAX));
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            dist[i][1 << i] = 0;
            q.emplace(i, 1 << i);
        }
        int ans = 0;
        while (!q.empty()) {
            auto [u, mask] = q.front();
            q.pop();
            if (mask == (1 << n) - 1) {
                ans = dist[u][mask];
                break;
            }
            for (int v : graph[u]) {
                int mask_v = mask | (1 << v);
                if (dist[v][mask_v] == INT_MAX) {
                    dist[v][mask_v] = dist[u][mask] + 1;
                    q.emplace(v, mask_v);
                }
            }
        }
        return ans;
    }
};