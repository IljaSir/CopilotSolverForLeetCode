class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        int n = amount.size();
        vector<int> adj[n];
        for (int i = 0; i < n - 1; i++) {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        int dp[n][2];
        memset(dp, 0, sizeof(dp));
        dfs(adj, 0, -1, bob, amount, dp);
        return dp[0][0];
    }
    void dfs(vector<int> adj[], int u, int p, int bob, vector<int>& amount, int dp[][2]) {
        for (int v : adj[u]) {
            if (v != p) {
                dfs(adj, v, u, bob, amount, dp);
                int sum = dp[v][0] + amount[u];
                if (sum > dp[u][0]) {
                    dp[u][1] = dp[u][0];
                    dp[u][0] = sum;
                } else if (sum > dp[u][1]) {
                    dp[u][1] = sum;
                }
            }
        }
        if (u == bob) {
            dp[u][0] = dp[u][1];
        }
    }
};