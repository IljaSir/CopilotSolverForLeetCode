class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> result;
        vector<int> path;
        path.push_back(0);
        dfs(graph, 0, path, result);
        return result;
    }
    
    void dfs(vector<vector<int>>& graph, int curr, vector<int>& path, vector<vector<int>>& result) {
        if (curr == graph.size() - 1) {
            result.push_back(path);
            return;
        }
        
        for (int i = 0; i < graph[curr].size(); i++) {
            int next = graph[curr][i];
            path.push_back(next);
            dfs(graph, next, path, result);
            path.pop_back();
        }
    }
};