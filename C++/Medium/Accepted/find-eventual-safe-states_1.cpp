class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> color(n, 0);
        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, color)) {
                res.push_back(i);
            }
        }
        return res;
    }
    bool dfs(vector<vector<int>>& graph, int i, vector<int>& color) {
        if (color[i] > 0) {
            return color[i] == 2;
        }
        color[i] = 1;
        for (auto j : graph[i]) {
            if (!dfs(graph, j, color)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
};