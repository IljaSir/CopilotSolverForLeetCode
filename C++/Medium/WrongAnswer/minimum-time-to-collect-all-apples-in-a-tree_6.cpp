class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> visited(n, 0);
        dfs(0, graph, visited, hasApple);
        return 2 * (n - 1 - visited[0]);
    }
    
    int dfs(int cur, vector<vector<int>>& graph, vector<int>& visited, vector<bool>& hasApple) {
        visited[cur] = 1;
        int res = 0;
        for (auto& next : graph[cur]) {
            if (visited[next] == 0) {
                res += dfs(next, graph, visited, hasApple);
            }
        }
        if (res == 0 && hasApple[cur] == false) {
            return 0;
        }
        return 1 + res;
    }
};