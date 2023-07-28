class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (const auto& edge: connections) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> rank(n, -1);
        int r = 0;
        vector<vector<int>> res;
        dfs(0, -1, rank, r, graph, res);
        return res;
    }
};