class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> g(n);
        for (auto& e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v: g[u]) {
                if (v == p) continue;
                if (vals[v] >= vals[u]) continue;
                dp[v] = 1 + dp[u];
                dfs(v, u);
            }
        };
        dfs(0, -1);
        return accumulate(dp.begin(), dp.end(), 0LL);
    }
};