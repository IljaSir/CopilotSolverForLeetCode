class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        vector<vector<int>> adj(amount.size());
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dp(amount.size());
        function<void(int, int)> dfs = [&](int u, int p) {
            dp[u] = amount[u];
            for (auto v : adj[u]) {
                if (v == p) continue;
                dfs(v, u);
                if (dp[v] > 0) dp[u] += dp[v];
            }
        };
        dfs(0, -1);
        int res = amount[0];
        for (auto v : adj[0]) {
            if (dp[v] > 0) res += dp[v];
        }
        return res - amount[bob] / 2;
    }
};