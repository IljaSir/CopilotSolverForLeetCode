class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> g(n);
        for (auto& e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        int ans = 0;
        function<int(int, int)> dfs = [&](int u, int v) {
            if (dp[u][v] != -1) {
                return dp[u][v];
            }
            if (vals[u] != vals[v]) {
                return 0;
            }
            int ans = 1;
            for (int w: g[v]) {
                if (w != u && vals[w] <= vals[u]) {
                    ans = (ans + dfs(v, w)) % 1000000007;
                }
            }
            return dp[u][v] = ans;
        };
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = (ans + dfs(i, j)) % 1000000007;
            }
        }
        return ans;
    }
};