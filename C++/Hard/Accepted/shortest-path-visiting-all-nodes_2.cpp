class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        queue<tuple<int, int, int>> q;
        for (int i = 0; i < n; ++i) {
            q.push({i, 1 << i, 0});
        }
        vector<vector<bool>> seen(n, vector<bool>(1 << n));
        while (!q.empty()) {
            auto [u, mask, dist] = q.front();
            q.pop();
            if (mask == (1 << n) - 1) {
                return dist;
            }
            if (seen[u][mask]) {
                continue;
            }
            seen[u][mask] = true;
            for (int v : graph[u]) {
                q.push({v, mask | (1 << v), dist + 1});
            }
        }
        return 0;
    }
};