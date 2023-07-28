class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> adj(n);
        for (auto &edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return dfs(vals, adj, dp, 0, vals[0]);
    }
    int dfs(vector<int>& vals, vector<vector<int>>& adj, vector<vector<int>>& dp, int u, int cur) {
        if (dp[u][cur] != -1) return dp[u][cur];
        int ans = 0;
        for (int v: adj[u]) {
            if (vals[v] >= cur) {
                ans += dfs(vals, adj, dp, v, cur);
            }
        }
        if (u == 0) ans++; // self loop
        return dp[u][cur] = ans;
    }
};