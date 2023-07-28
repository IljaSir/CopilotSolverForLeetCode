class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        vector<vector<int>> paths;
        vector<int> path;
        path.push_back(0);
        dfs(graph, path, paths, 0);
        return paths;
    }
    void dfs(vector<vector<int>>& graph, vector<int>& path, vector<vector<int>>& paths, int node){
        if(node == graph.size() - 1){
            paths.push_back(path);
            return;
        }
        for(int i = 0; i < graph[node].size(); i++){
            path.push_back(graph[node][i]);
            dfs(graph, path, paths, graph[node][i]);
            path.pop_back();
        }
    }
};