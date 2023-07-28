class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        // build graph
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n, false);
        return dfs(graph, hasApple, visited, 0) * 2;
    }
    
    int dfs(vector<vector<int>>& graph, vector<bool>& hasApple, vector<bool>& visited, int node) {
        visited[node] = true;
        int time = 0;
        for (auto& child : graph[node]) {
            if (visited[child]) continue;
            time += dfs(graph, hasApple, visited, child);
        }
        if (time == 0 && !hasApple[node]) return 0;
        return time + 1;
    }
};