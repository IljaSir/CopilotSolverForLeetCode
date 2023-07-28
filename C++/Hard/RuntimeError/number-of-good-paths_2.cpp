class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return dfs(0, 0, vals, adj, dp);
    }
    int dfs(int u, int v, vector<int>& vals, vector<vector<int>>& adj, vector<vector<int>>& dp) {
        if (dp[u][v] != -1) return dp[u][v];
        if (vals[u] < vals[v]) {
            dp[u][v] = 0;
            return 0;
        }
        int ans = 0;
        if (u == v) ans++;
        for (int w : adj[u]) {
            if (w == v) continue;
            ans += dfs(w, v, vals, adj, dp);
            if (ans >= 1000000007) ans -= 1000000007;
        }
        dp[u][v] = ans;
        return ans;
    }
};