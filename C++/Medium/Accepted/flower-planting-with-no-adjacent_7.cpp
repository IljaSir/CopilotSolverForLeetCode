class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<int> result(n, 0);
        vector<vector<int>> graph(n);
        for (auto& path : paths) {
            graph[path[0] - 1].push_back(path[1] - 1);
            graph[path[1] - 1].push_back(path[0] - 1);
        }
        for (int i = 0; i < n; ++i) {
            vector<bool> used(5, false);
            for (int j : graph[i]) {
                used[result[j]] = true;
            }
            for (int j = 1; j <= 4; ++j) {
                if (!used[j]) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }
};