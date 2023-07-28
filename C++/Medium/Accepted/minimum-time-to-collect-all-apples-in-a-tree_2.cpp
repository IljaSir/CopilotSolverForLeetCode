class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        vector<vector<int>> graph(n);
        for (auto e: edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n, false);
        return dfs(graph, visited, hasApple, 0);
    }
    int dfs(vector<vector<int>>& graph, vector<bool>& visited, vector<bool>& hasApple, int node) {
        visited[node] = true;
        int ret = 0;
        for (auto adj: graph[node]) {
            if (!visited[adj]) {
                int res = dfs(graph, visited, hasApple, adj);
                if (res > 0 || hasApple[adj]) {
                    ret += res + 2;
                }
            }
        }
        return ret;
    }
};