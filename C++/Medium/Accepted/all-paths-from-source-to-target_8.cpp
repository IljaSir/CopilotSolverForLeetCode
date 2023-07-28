class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> ans;
        int n = graph.size();
        vector<int> path;
        path.push_back(0);
        dfs(graph, ans, path, 0, n-1);
        return ans;
    }
    
    void dfs(vector<vector<int>>& graph, vector<vector<int>>& ans, vector<int>& path, int start, int end) {
        if (start == end) {
            ans.push_back(path);
            return;
        }
        
        for (int i = 0; i < graph[start].size(); i++) {
            path.push_back(graph[start][i]);
            dfs(graph, ans, path, graph[start][i], end);
            path.pop_back();
        }
    }
};