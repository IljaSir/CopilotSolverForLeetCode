class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> adj(n);
        for (auto e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n, false);
        return dfs(adj, visited, source, destination);
    }
    
    bool dfs(vector<vector<int>>& adj, vector<bool>& visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int i = 0; i < adj[source].size(); i++) {
            if (!visited[adj[source][i]]) {
                if (dfs(adj, visited, adj[source][i], destination)) {
                    return true;
                }
            }
        }
        return false;
    }
};