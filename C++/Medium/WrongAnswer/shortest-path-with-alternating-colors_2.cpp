class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<vector<int>>> edges(n, vector<vector<int>>(2));
        for (auto& edge : redEdges) {
            edges[edge[0]][0].push_back(edge[1]);
        }
        for (auto& edge : blueEdges) {
            edges[edge[0]][1].push_back(edge[1]);
        }
        vector<vector<int>> dist(n, vector<int>(2, -1));
        dist[0][0] = dist[0][1] = 0;
        queue<array<int, 2>> q;
        q.push({0, 0});
        q.push({0, 1});
        while (!q.empty()) {
            auto [node, color] = q.front();
            q.pop();
            for (auto& nei : edges[node][color ^ 1]) {
                if (dist[nei][color ^ 1] == -1) {
                    dist[nei][color ^ 1] = dist[node][color] + 1;
                    q.push({nei, color ^ 1});
                }
            }
        }
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            ans[i] = max(dist[i][0], dist[i][1]);
        }
        return ans;
    }
};