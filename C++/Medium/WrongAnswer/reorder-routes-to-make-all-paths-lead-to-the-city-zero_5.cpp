class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : connections) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(-edge[0]);
        }
        queue<int> q;
        q.push(0);
        int result = 0;
        vector<bool> visited(n);
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            visited[node] = true;
            for (int neighbor : graph[node]) {
                if (neighbor < 0) {
                    neighbor = -neighbor;
                    if (!visited[neighbor]) {
                        q.push(neighbor);
                    }
                } else {
                    result++;
                    if (!visited[neighbor]) {
                        q.push(neighbor);
                    }
                }
            }
        }
        return result;
    }
};