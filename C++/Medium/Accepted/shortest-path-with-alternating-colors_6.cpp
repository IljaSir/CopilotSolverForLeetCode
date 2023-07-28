class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<vector<int>>> graph(n, vector<vector<int>>(2, vector<int>()));
        for (auto& edge : redEdges)
            graph[edge[0]][0].push_back(edge[1]);
        for (auto& edge : blueEdges)
            graph[edge[0]][1].push_back(edge[1]);
        vector<vector<int>> dist(n, vector<int>(2, INT_MAX));
        dist[0][0] = 0;
        dist[0][1] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        q.push({0, 1});
        while (!q.empty()) {
            auto [node, color] = q.front();
            q.pop();
            for (auto& nei : graph[node][1 - color]) {
                if (dist[nei][1 - color] > dist[node][color] + 1) {
                    dist[nei][1 - color] = dist[node][color] + 1;
                    q.push({nei, 1 - color});
                }
            }
        }
        vector<int> ans(n, INT_MAX);
        for (int i = 0; i < n; ++i) {
            ans[i] = min(dist[i][0], dist[i][1]);
            if (ans[i] == INT_MAX)
                ans[i] = -1;
        }
        return ans;
    }
};