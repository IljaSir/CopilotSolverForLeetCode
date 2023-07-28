class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        
        vector<int> ans(n, INT_MAX);
        ans[0] = 0;
        vector<vector<vector<int>>> graph(n, vector<vector<int>>(2, vector<int>()));
        for (auto& e : redEdges) {
            graph[e[0]][0].push_back(e[1]);
        }
        for (auto& e : blueEdges) {
            graph[e[0]][1].push_back(e[1]);
        }
        queue<pair<int, int>> q;
        q.push({0, 0});
        q.push({0, 1});
        int step = 0;
        while (!q.empty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto [cur, color] = q.front();
                q.pop();
                for (auto& next : graph[cur][color]) {
                    if (ans[next] == INT_MAX) {
                        ans[next] = step;
                        q.push({next, 1 - color});
                    }
                }
            }
        }
        for (auto& v : ans) {
            if (v == INT_MAX) {
                v = -1;
            }
        }
        return ans;
    }
};