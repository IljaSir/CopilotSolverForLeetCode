class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> visited(n);
        int cc = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            cc++;
            dfs(i, adj, visited);
        }
        long long result = 0;
        for (int i = 0; i < cc; ++i) {
            result += (n - i - 1);
        }
        return result;
    }
};