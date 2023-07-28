class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        int n = amount.size();
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(2));
        dfs(g, amount, dp, 0, -1);
        return max(dp[0][0] - dp[bob][1], dp[0][1] - dp[bob][0]);
    }
    
    void dfs(vector<vector<int>> &g, vector<int> &amount, vector<vector<int>> &dp, int u, int fa) {
        dp[u][0] = dp[u][1] = amount[u];
        for (int v : g[u]) {
            if (v == fa) continue;
            dfs(g, amount, dp, v, u);
            dp[u][0] = max(dp[u][0], dp[v][0] + amount[u]);
            dp[u][1] = max(dp[u][1], dp[v][1] + amount[u]);
        }
    }
};