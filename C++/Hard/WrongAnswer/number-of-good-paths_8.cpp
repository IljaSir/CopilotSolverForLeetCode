class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        const int MOD = 1'000'000'007;
        int n = vals.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        function<int(int, int)> dfs = [&](int u, int p) {
            int& ans = dp[u][p];
            if (ans != -1) return ans;
            if (vals[u] < vals[p]) return ans = 0;
            ans = 1;
            for (int v : g[u]) {
                if (v != p) ans = (ans + dfs(v, u)) % MOD;
            }
            return ans;
        };
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + dfs(i, i)) % MOD;
        }
        return ans;
    }
};