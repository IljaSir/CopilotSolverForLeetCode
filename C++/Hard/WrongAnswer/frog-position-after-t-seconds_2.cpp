class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> graph(n + 1);
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n + 1, false);
        queue<int> q;
        q.push(1);
        visited[1] = true;
        int level = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                if (node == target) {
                    if (level == t || graph[node].size() == 1) {
                        return 1.0;
                    }
                    return 0.0;
                }
                int count = 0;
                for (int j = 0; j < graph[node].size(); j++) {
                    if (!visited[graph[node][j]]) {
                        count++;
                    }
                }
                for (int j = 0; j < graph[node].size(); j++) {
                    if (!visited[graph[node][j]]) {
                        q.push(graph[node][j]);
                        visited[graph[node][j]] = true;
                    }
                }
            }
            level++;
        }
        return 0.0;
    }
};