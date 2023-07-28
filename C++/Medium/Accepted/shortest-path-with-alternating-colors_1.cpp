class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<vector<int>>> graph(n, vector<vector<int>>(2, vector<int>()));
        for (auto& edge : redEdges) {
            graph[edge[0]][0].push_back(edge[1]);
        }
        for (auto& edge : blueEdges) {
            graph[edge[0]][1].push_back(edge[1]);
        }
        vector<vector<int>> dist(n, vector<int>(2, INT_MAX));
        dist[0][0] = dist[0][1] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        q.push({0, 1});
        while (!q.empty()) {
            int node = q.front().first;
            int color = q.front().second;
            q.pop();
            for (int nei : graph[node][color]) {
                if (dist[nei][color ^ 1] == INT_MAX) {
                    dist[nei][color ^ 1] = dist[node][color] + 1;
                    q.push({nei, color ^ 1});
                }
            }
        }
        vector<int> ans(n, -1);
        for (int i = 0; i < n; i++) {
            if (dist[i][0] != INT_MAX || dist[i][1] != INT_MAX) {
                ans[i] = min(dist[i][0], dist[i][1]);
            }
        }
        return ans;
    }
};