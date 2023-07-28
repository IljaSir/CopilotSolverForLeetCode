class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> ret;
        vector<int> path;
        int n = graph.size();
        path.push_back(0);
        dfs(0, n, graph, path, ret);
        return ret;
    }
    void dfs(int u, int n, vector<vector<int>>& graph, vector<int>& path, vector<vector<int>>& ret) {
        if (u == n - 1) {
            ret.push_back(path);
            return;
        }
        for (int v : graph[u]) {
            path.push_back(v);
            dfs(v, n, graph, path, ret);
            path.pop_back();
        }
    }
};