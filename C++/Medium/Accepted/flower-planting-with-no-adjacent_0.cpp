class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<vector<int>> graph(n);
        for (auto& path : paths) {
            graph[path[0] - 1].push_back(path[1] - 1);
            graph[path[1] - 1].push_back(path[0] - 1);
        }
        vector<int> result(n);
        for (int i = 0; i < n; ++i) {
            bool used[5] = {false};
            for (int j : graph[i]) {
                used[result[j]] = true;
            }
            for (int color = 4; color > 0; --color) {
                if (!used[color]) {
                    result[i] = color;
                    break;
                }
            }
        }
        return result;
    }
};