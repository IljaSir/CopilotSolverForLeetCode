class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> res;
        vector<int> path;
        path.push_back(0);
        dfs(graph, 0, res, path);
        return res;
    }
    
    void dfs(vector<vector<int>>& graph, int u, vector<vector<int>>& res, vector<int>& path){
        int n = graph.size();
        if(u == n-1){
            res.push_back(path);
            return;
        }
        
        for(int v: graph[u]){
            path.push_back(v);
            dfs(graph, v, res, path);
            path.pop_back();
        }
    }
};