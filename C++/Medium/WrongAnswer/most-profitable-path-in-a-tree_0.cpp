class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        int n = amount.size();
        vector<vector<int>> g(n);
        for (auto& e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(2, -1e9));
        dp[0][0] = 0;
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v: g[u]) {
                if (v == p) continue;
                dfs(v, u);
                dp[u][0] = max(dp[u][0], max(dp[v][0], dp[v][1]));
                dp[u][1] = max(dp[u][1], dp[v][0]);
            }
            dp[u][0] += amount[u] / 2;
            dp[u][1] += amount[u];
        };
        dfs(0, -1);
        return max(dp[0][0], dp[0][1] - amount[bob]);
    }
};