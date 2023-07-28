class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n+1);
        vector<int> degree(n+1);
        for (auto& edge: edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        queue<int> q;
        for (int i = 1; i <= n; ++i) {
            if (degree[i] % 2 == 1) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int neighbor: graph[node]) {
                degree[neighbor]--;
                if (degree[neighbor] % 2 == 1) {
                    q.push(neighbor);
                }
            }
        }
        for (int i = 1; i <= n; ++i) {
            if (degree[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }
};