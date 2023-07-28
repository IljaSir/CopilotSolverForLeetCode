class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        int n = amount.size();
        vector<vector<int>> adj(n);
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, INT_MIN);
        dp[0] = 0;
        dfs(0, -1, adj, dp, amount);
        return dp[bob];
    }
};