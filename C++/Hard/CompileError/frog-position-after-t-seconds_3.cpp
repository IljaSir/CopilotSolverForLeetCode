class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> adj(n);
        for (auto e : edges) {
            adj[e[0] - 1].push_back(e[1] - 1);
            adj[e[1] - 1].push_back(e[0] - 1);
        }
        vector<bool> visited(n);
        return dfs(adj, visited, target - 1, 0, t, 1);
    }
};