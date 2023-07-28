class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> graph(n, vector<int>());
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        queue<int> q;
        q.push(source);
        vector<bool> visited(n, false);
        visited[source] = true;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (cur == destination) {
                return true;
            }
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.push(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
};