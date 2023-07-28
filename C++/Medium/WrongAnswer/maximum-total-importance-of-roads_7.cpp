class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : roads) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> visited(n, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ans = max(ans, dfs(i, graph, visited));
            }
        }
        return ans;
    }
    
    int dfs(int node, vector<vector<int>>& graph, vector<int>& visited) {
        visited[node] = 1;
        int ans = node + 1;
        for (int nei : graph[node]) {
            if (!visited[nei]) {
                ans += dfs(nei, graph, visited);
            }
        }
        return ans;
    }
};