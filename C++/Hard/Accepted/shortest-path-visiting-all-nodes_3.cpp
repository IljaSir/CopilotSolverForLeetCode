class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        queue<tuple<int, int, int>> q;
        vector<vector<int>> visited(n, vector<int>(1 << n));
        for (int i = 0; i < n; i++) {
            q.emplace(i, 1 << i, 0);
            visited[i][1 << i] = 1;
        }
        int ans = 0;
        while (!q.empty()) {
            auto [u, mask, dist] = q.front();
            q.pop();
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            for (int v : graph[u]) {
                int mask_v = mask | (1 << v);
                if (!visited[v][mask_v]) {
                    q.emplace(v, mask_v, dist + 1);
                    visited[v][mask_v] = 1;
                }
            }
        }
        return ans;
    }
};