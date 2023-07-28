class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        int res = 0;
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<bool> visited(n, false);
        dfs(0, adj, hasApple, visited, res);
        return res;
    }
    
    void dfs(int cur, vector<vector<int>>& adj, vector<bool>& hasApple, vector<bool>& visited, int& res) {
        visited[cur] = true;
        for (int next : adj[cur]) {
            if (visited[next]) continue;
            dfs(next, adj, hasApple, visited, res);
            if (hasApple[next] || visited[next]) {
                res += 2;
            }
        }
    }
};