class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> adj(n);
        for (int i = 1; i < n; ++i) {
            adj[parent[i]].push_back(i);
        }
        vector<int> dp(n, 0);
        int res = 0;
        function<void(int)> dfs = [&](int u) {
            for (int v : adj[u]) {
                dfs(v);
                if (s[u] != s[v]) {
                    dp[u] = max(dp[u], dp[v] + 1);
                }
            }
            res = max(res, dp[u]);
        };
        dfs(0);
        return res;
    }
};