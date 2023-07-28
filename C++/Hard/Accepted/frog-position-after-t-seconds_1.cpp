class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> adj(n + 1);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> visited(n + 1);
        return dfs(adj, visited, 1, t, target);
    }
    double dfs(vector<vector<int>>& adj, vector<int>& visited, int node, int t, int target) {
        if (t < 0) return 0;
        if (node == target) {
            if (t == 0) return 1;
            for (int i = 0; i < adj[node].size(); i++) {
                if (!visited[adj[node][i]]) return 0;
            }
            return 1;
        }
        visited[node] = 1;
        double res = 0;
        int cnt = 0;
        for (int i = 0; i < adj[node].size(); i++) {
            if (!visited[adj[node][i]]) {
                cnt++;
            }
        }
        for (int i = 0; i < adj[node].size(); i++) {
            if (!visited[adj[node][i]]) {
                res += dfs(adj, visited, adj[node][i], t - 1, target) / cnt;
            }
        }
        return res;
    }
};