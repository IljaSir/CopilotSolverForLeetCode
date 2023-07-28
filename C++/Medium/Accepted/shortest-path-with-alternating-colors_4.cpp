class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<vector<int>>> graph(n, vector<vector<int>>(2, vector<int>()));
        for (auto e : redEdges) graph[e[0]][0].push_back(e[1]);
        for (auto e : blueEdges) graph[e[0]][1].push_back(e[1]);
        vector<vector<int>> dist(n, vector<int>(2, INT_MAX));
        queue<vector<int>> q;
        q.push({0, 0}); q.push({0, 1});
        dist[0][0] = 0; dist[0][1] = 0;
        while (!q.empty()) {
            auto cur = q.front(); q.pop();
            int node = cur[0], color = cur[1];
            for (auto next : graph[node][1 - color]) {
                if (dist[next][1 - color] > dist[node][color] + 1) {
                    dist[next][1 - color] = dist[node][color] + 1;
                    q.push({next, 1 - color});
                }
            }
        }
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            int d = min(dist[i][0], dist[i][1]);
            ans[i] = (d == INT_MAX) ? -1 : d;
        }
        return ans;
    }
};