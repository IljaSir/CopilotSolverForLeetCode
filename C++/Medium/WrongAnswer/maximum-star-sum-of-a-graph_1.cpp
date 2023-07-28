class Solution {
public:
    int maxStarSum(vector<int>& vals, vector<vector<int>>& edges, int k) {
        
        const int n = vals.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<int> dp(n);
        vector<vector<int>> dp2(n, vector<int>(k + 1));
        function<void(int, int)> dfs = [&](int u, int fa) {
            dp[u] = vals[u];
            dp2[u][0] = vals[u];
            for (int v : adj[u]) {
                if (v == fa) {
                    continue;
                }
                dfs(v, u);
                dp[u] += max(0, dp[v]);
                for (int i = 1; i <= k; ++i) {
                    dp2[u][i] = max(dp2[u][i], dp2[u][i - 1] + max(0, dp2[v][i - 1]));
                }
            }
        };
        dfs(0, -1);
        int ans = 0;
        for (int i = 0; i <= k; ++i) {
            ans = max(ans, dp2[0][i]);
        }
        return ans;
    }
};