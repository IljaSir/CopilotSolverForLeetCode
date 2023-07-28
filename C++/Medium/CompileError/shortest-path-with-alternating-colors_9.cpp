class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<int> res(n, -1);
        vector<vector<vector<int>>> graph(n, vector<vector<int>>(2, vector<int>()));
        for (auto& r: redEdges) graph[r[0]][0].push_back(r[1]);
        for (auto& b: blueEdges) graph[b[0]][1].push_back(b[1]);
        queue<vector<int>> q; // {node, color, dist}
        q.push({0, 0, 0});
        q.push({0, 1, 0});
        while (!q.empty()) {
            auto [node, color, dist] = q.front(); q.pop();
            if (res[node] != -1) continue;
            res[node] = dist;
            for (auto nei: graph[node][color ^ 1]) q.push({nei, color ^ 1, dist + 1});
        }
        return res;
    }
};