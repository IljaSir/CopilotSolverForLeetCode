class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> g(n);
        for (auto& r : roads) {
            g[r[0]].push_back(r[1]);
            g[r[1]].push_back(r[0]);
        }
        vector<int> v(n, 0);
        for (int i = 0; i < n; ++i) v[i] = i + 1;
        long long ans = 0;
        function<void(int, int)> dfs = [&](int u, int p) {
            for (int v : g[u]) {
                if (v == p) continue;
                ans += v[u] + v[v];
                dfs(v, u);
            }
        };
        dfs(0, -1);
        return ans;
    }
};