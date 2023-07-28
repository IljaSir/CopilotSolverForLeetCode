class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<vector<int>> red(n, vector<int>());
        vector<vector<int>> blue(n, vector<int>());
        for (auto& edge: redEdges) {
            red[edge[0]].push_back(edge[1]);
        }
        for (auto& edge: blueEdges) {
            blue[edge[0]].push_back(edge[1]);
        }
        vector<vector<int>> dist(n, vector<int>(2, INT_MAX));
        dist[0][0] = dist[0][1] = 0;
        queue<pair<int, int>> q;
        q.push({0, 0});
        q.push({0, 1});
        while (!q.empty()) {
            auto [u, c] = q.front();
            q.pop();
            if (c == 0) {
                for (int v: blue[u]) {
                    if (dist[v][1] == INT_MAX) {
                        dist[v][1] = dist[u][0] + 1;
                        q.push({v, 1});
                    }
                }
            } else {
                for (int v: red[u]) {
                    if (dist[v][0] == INT_MAX) {
                        dist[v][0] = dist[u][1] + 1;
                        q.push({v, 0});
                    }
                }
            }
        }
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            int d = min(dist[i][0], dist[i][1]);
            ans[i] = d == INT_MAX ? -1 : d;
        }
        return ans;
    }
};