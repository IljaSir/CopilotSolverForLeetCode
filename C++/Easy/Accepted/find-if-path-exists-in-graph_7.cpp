class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> graph(n);
        for (auto &edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n);
        visited[source] = true;
        queue<int> q;
        q.push(source);
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            if (node == destination)
                return true;
            for (auto &v : graph[node]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.push(v);
                }
            }
        }
        return false;
    }
};