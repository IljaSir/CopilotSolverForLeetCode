class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> result;
        vector<int> path;
        path.push_back(0);
        dfs(graph, result, path, 0);
        return result;
    }
    void dfs(vector<vector<int>>& graph, vector<vector<int>>& result, vector<int>& path, int node) {
        if (node == graph.size() - 1) {
            result.push_back(path);
            return;
        }
        for (int i = 0; i < graph[node].size(); i++) {
            path.push_back(graph[node][i]);
            dfs(graph, result, path, graph[node][i]);
            path.pop_back();
        }
    }
};