class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        unordered_map<int, vector<int>> adj;
        for (auto &e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n, false);
        return dfs(0, adj, hasApple, visited);
    }
    int dfs(int node, unordered_map<int, vector<int>> &adj, vector<bool> &hasApple, vector<bool> &visited) {
        visited[node] = true;
        int res = 0;
        for (auto &n : adj[node]) {
            if (!visited[n]) {
                int t = dfs(n, adj, hasApple, visited);
                if (t > 0 || hasApple[n]) {
                    res += t + 2;
                }
            }
        }
        return res;
    }
};