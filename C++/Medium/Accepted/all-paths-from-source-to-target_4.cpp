class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> result;
        vector<int> path;
        dfs(graph, 0, path, result);
        return result;
    }
    void dfs(vector<vector<int>>& graph, int cur, vector<int>& path, vector<vector<int>>& result) {
        path.push_back(cur);
        if (cur == graph.size() - 1) {
            result.push_back(path);
        }
        for (int i = 0; i < graph[cur].size(); i++) {
            dfs(graph, graph[cur][i], path, result);
        }
        path.pop_back();
    }
};