class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> res;
        vector<int> color(n, 0);
        for (int i = 0; i < n; ++i) {
            if (dfs(graph, color, i)) {
                res.push_back(i);
            }
        }
        return res;
    }
    bool dfs(vector<vector<int>>& graph, vector<int>& color, int i) {
        if (color[i] > 0) {
            return color[i] == 2;
        }
        color[i] = 1;
        for (int j : graph[i]) {
            if (!dfs(graph, color, j)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
};