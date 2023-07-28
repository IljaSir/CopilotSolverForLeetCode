class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<vector<int>> graph(n);
        for (int i = 0; i < n; ++i) {
            if (edges[i] == -1) continue;
            graph[i].push_back(edges[i]);
        }
        vector<int> visited(n, 0);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                int cycle = dfs(graph, visited, i);
                if (cycle != -1) res = max(res, cycle);
            }
        }
        return res;
    }
    
    int dfs(vector<vector<int>>& graph, vector<int>& visited, int i) {
        if (visited[i] == 1) return 1;
        if (visited[i] == 2) return -1;
        visited[i] = 1;
        int res = -1;
        for (int v : graph[i]) {
            int cycle = dfs(graph, visited, v);
            if (cycle != -1) res = max(res, cycle + 1);
        }
        visited[i] = 2;
        return res;
    }
};