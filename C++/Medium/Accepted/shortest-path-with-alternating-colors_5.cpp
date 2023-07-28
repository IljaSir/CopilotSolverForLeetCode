class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<int>> red(n, vector<int>());
        vector<vector<int>> blue(n, vector<int>());
        for (auto& e : redEdges) red[e[0]].push_back(e[1]);
        for (auto& e : blueEdges) blue[e[0]].push_back(e[1]);
        vector<vector<int>> dist(n, vector<int>(2, -1));
        queue<pair<int, int>> q;
        dist[0][0] = dist[0][1] = 0;
        q.push({0,0});
        q.push({0,1});
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            step++;
            while (size--) {
                auto [node, color] = q.front(); q.pop();
                auto& edges = color == 0 ? red : blue;
                for (auto e : edges[node]) {
                    if (dist[e][1-color] == -1) {
                        dist[e][1-color] = step;
                        q.push({e, 1-color});
                    }
                }
            }
        }
        vector<int> ans(n, -1);
        for (int i = 0; i < n; ++i) {
            ans[i] = dist[i][0] == -1 ? dist[i][1] : dist[i][1] == -1 ? dist[i][0] : min(dist[i][0], dist[i][1]);
        }
        return ans;
    }
};