class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<vector<int>> graph(n);
        for (auto &e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> dp(n);
        vector<vector<int>> dp1(n);
        for (auto &d : dp1) d.resize(n);
        vector<vector<int>> dp2(n);
        for (auto &d : dp2) d.resize(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            for (auto v : graph[u]) {
                if (v == p) continue;
                dfs(v, u);
            }
            dp[u] = coins[u];
            for (auto v : graph[u]) {
                if (v == p) continue;
                dp[u] += dp[v];
            }
            for (auto v : graph[u]) {
                if (v == p) continue;
                dp1[u][v] = dp[v];
            }
            for (auto v : graph[u]) {
                if (v == p) continue;
                for (auto w : graph[u]) {
                    if (w == p || w == v) continue;
                    dp1[u][v] = max(dp1[u][v], dp1[u][w] + dp[v]);
                }
            }
            for (auto v : graph[u]) {
                if (v == p) continue;
                dp2[u][v] = dp[u] - dp[v];
            }
            for (auto v : graph[u]) {
                if (v == p) continue;
                for (auto w : graph[u]) {
                    if (w == p || w == v) continue;
                    dp2[u][v] = max(dp2[u][v], dp2[u][w] + dp[v]);
                }
            }
        };
        dfs(0, -1);
        int ans = 0;
        for (auto v : graph[0]) {
            ans = max(ans, dp1[0][v] + dp2[0][v]);
        }
        return dp[0] - ans;
    }
};