class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> graph(n + 1);
        for (auto e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n + 1);
        return dfs(graph, visited, 1, t, target);
    }
    
    double dfs(vector<vector<int>>& graph, vector<bool>& visited, int node, int t, int target) {
        if (visited[node]) {
            return 0;
        }
        if (t == 0) {
            return node == target ? 1 : 0;
        }
        visited[node] = true;
        int n = graph[node].size();
        for (int i = 0; i < graph[node].size(); i++) {
            if (visited[graph[node][i]]) {
                n--;
            }
        }
        double res = 0;
        for (int i = 0; i < graph[node].size(); i++) {
            if (!visited[graph[node][i]]) {
                res += dfs(graph, visited, graph[node][i], t - 1, target) / n;
            }
        }
        visited[node] = false;
        return res;
    }
};