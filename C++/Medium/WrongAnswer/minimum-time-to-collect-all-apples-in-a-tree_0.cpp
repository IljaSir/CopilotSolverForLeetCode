class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n, false);
        return dfs(graph, visited, hasApple, 0);
    }
    
    int dfs(vector<vector<int>>& graph, vector<bool>& visited, vector<bool>& hasApple, int node) {
        if (visited[node]) return 0;
        visited[node] = true;
        int total = 0;
        for (int neighbor : graph[node]) {
            total += dfs(graph, visited, hasApple, neighbor);
        }
        if (total > 0 || hasApple[node]) {
            return total + 2;
        } else {
            return 0;
        }
    }
};