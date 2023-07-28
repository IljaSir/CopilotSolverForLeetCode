class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<vector<int>> adj(n);
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dp(n);
        dfs(0, -1, coins, adj, dp);
        return dp[0];
    }
    void dfs(int u, int p, vector<int>& coins, vector<vector<int>>& adj, vector<int>& dp) {
        dp[u] = coins[u];
        for (int v : adj[u]) {
            if (v == p) continue;
            dfs(v, u, coins, adj, dp);
            dp[u] += min(dp[v], 2);
        }
    }
};