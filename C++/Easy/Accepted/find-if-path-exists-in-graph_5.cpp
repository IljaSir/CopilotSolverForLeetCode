class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n);
        queue<int> q;
        q.push(source);
        visited[source] = true;
        while (!q.empty()) {
            auto u = q.front(); q.pop();
            if (u == destination) return true;
            for (auto v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.push(v);
                }
            }
        }
        return false;
    }
};