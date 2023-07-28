class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        int res = 0;
        function<int(int, int)> dfs = [&](int u, int p) {
            if (dp[u][p] != -1) return dp[u][p];
            int res = vals[u] >= vals[p];
            for (int v : adj[u]) {
                if (v == p) continue;
                if (vals[v] <= vals[u]) res += dfs(v, u);
            }
            return dp[u][p] = res;
        };
        for (int i = 0; i < n; i++) {
            res += dfs(i, i);
        }
        return res;
    }
};