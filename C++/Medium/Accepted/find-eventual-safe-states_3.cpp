class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        vector<int> result;
        vector<int> color(graph.size(), 0);
        for (int i = 0; i < graph.size(); i++) {
            if (dfs(graph, color, i)) {
                result.push_back(i);
            }
        }
        return result;
    }

    bool dfs(vector<vector<int>>& graph, vector<int>& color, int i) {
        if (color[i] > 0) {
            return color[i] == 2;
        }
        color[i] = 1;
        for (auto j : graph[i]) {
            if (color[j] == 2) {
                continue;
            }
            if (color[j] == 1 || !dfs(graph, color, j)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
};