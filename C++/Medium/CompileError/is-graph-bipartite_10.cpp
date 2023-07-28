class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> color(n, 0);
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, 1, i)) {
                return false;
            }
        }
        return true;
    }
};