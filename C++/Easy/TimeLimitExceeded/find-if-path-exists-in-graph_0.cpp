class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(source);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (cur == destination) {
                return true;
            }
            visited[cur] = true;
            for (auto& next : graph[cur]) {
                if (!visited[next]) {
                    q.push(next);
                }
            }
        }
        return false;
    }
};