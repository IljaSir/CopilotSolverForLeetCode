class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        if (n == 1) return true;
        if (n == 2) return false;
        if (edges.size() < n - 1) return false;
        vector<int> degree(n + 1, 0);
        vector<vector<int>> adj(n + 1, vector<int>());
        for (auto edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        queue<int> q;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2) q.push(i);
        }
        while (!q.empty()) {
            int u = q.front(); q.pop();
            if (degree[u] % 2) {
                int v = adj[u][0];
                adj[u].erase(adj[u].begin());
                adj[v].erase(find(adj[v].begin(), adj[v].end(), u));
                degree[u]--;
                degree[v]--;
                if (degree[v] % 2) q.push(v);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2) return false;
        }
        return true;
    }
};