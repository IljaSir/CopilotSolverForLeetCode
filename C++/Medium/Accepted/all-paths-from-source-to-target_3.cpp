class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> res;
        vector<int> path;
        dfs(graph, 0, n - 1, path, res);
        return res;
    }
    
    void dfs(vector<vector<int>>& graph, int start, int end, vector<int> path, vector<vector<int>>& res) {
        path.push_back(start);
        if (start == end) {
            res.push_back(path);
            return;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            dfs(graph, graph[start][i], end, path, res);
        }
    }
};