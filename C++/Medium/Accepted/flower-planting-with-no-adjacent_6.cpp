class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<int> res(n, 0);
        vector<vector<int>> graph(n);
        for (auto& path : paths) {
            graph[path[0] - 1].push_back(path[1] - 1);
            graph[path[1] - 1].push_back(path[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            vector<bool> used(5, false);
            for (auto& j : graph[i]) {
                used[res[j]] = true;
            }
            for (int k = 1; k <= 4; k++) {
                if (!used[k]) {
                    res[i] = k;
                    break;
                }
            }
        }
        return res;
    }
};