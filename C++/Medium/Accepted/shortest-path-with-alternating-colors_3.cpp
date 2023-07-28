class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto e : redEdges) graph[e[0]].push_back({e[1], 0});
        for (auto e : blueEdges) graph[e[0]].push_back({e[1], 1});
        vector<vector<int>> dist(n, vector<int>(2, INT_MAX));
        dist[0][0] = 0;
        dist[0][1] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        q.push({0, 1});
        while (!q.empty()) {
            auto [u, c] = q.front();
            q.pop();
            for (auto [v, nc] : graph[u]) {
                if (nc == c) continue;
                if (dist[v][nc] > dist[u][c] + 1) {
                    dist[v][nc] = dist[u][c] + 1;
                    q.push({v, nc});
                }
            }
        }
        vector<int> ans(n, INT_MAX);
        for (int i = 0; i < n; i++) {
            ans[i] = min(dist[i][0], dist[i][1]);
            if (ans[i] == INT_MAX) ans[i] = -1;
        }
        return ans;
    }
};