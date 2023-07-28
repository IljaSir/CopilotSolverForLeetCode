class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        vector<int> result;
        vector<int> visited(graph.size(), 0);
        for (int i = 0; i < graph.size(); ++i) {
            if (dfs(graph, visited, i)) {
                result.push_back(i);
            }
        }
        return result;
    }
};