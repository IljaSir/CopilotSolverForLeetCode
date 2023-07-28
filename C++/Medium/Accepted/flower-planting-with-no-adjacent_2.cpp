class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<vector<int>> graph(n);
        for (auto& path: paths) {
            graph[path[0] - 1].push_back(path[1] - 1);
            graph[path[1] - 1].push_back(path[0] - 1);
        }
        vector<int> color(n);
        for (int i = 0; i < n; ++i) {
            vector<int> used(5);
            for (auto& j: graph[i]) {
                used[color[j]] = 1;
            }
            for (int c = 4; c >= 1; --c) {
                if (!used[c]) {
                    color[i] = c;
                }
            }
        }
        return color;
    }
};