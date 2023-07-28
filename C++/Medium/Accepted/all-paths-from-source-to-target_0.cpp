class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> res;
        vector<int> path;
        path.push_back(0);
        dfs(graph, res, path, 0);
        return res;
    }
    void dfs(vector<vector<int>>& graph, vector<vector<int>> &res, vector<int> &path, int node) {
        if (node == graph.size() - 1) {
            res.push_back(path);
            return;
        }
        for (int i = 0; i < graph[node].size(); i++) {
            path.push_back(graph[node][i]);
            dfs(graph, res, path, graph[node][i]);
            path.pop_back();
        }
    }
};