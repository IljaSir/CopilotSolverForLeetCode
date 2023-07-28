class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        unordered_map<int, vector<int>> graph;
        unordered_set<int> visited;
        int res = 0;
        for (auto& conn : connections) {
            graph[conn[0]].push_back(conn[1]);
            graph[conn[1]].push_back(-conn[0]);
        }
        dfs(graph, visited, 0, res);
        return res;
    }
};