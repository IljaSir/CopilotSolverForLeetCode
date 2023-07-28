class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        long long res = 0;
        vector<vector<int>> g(n);
        for (auto& r : roads) {
            g[r[0]].push_back(r[1]);
            g[r[1]].push_back(r[0]);
        }
        vector<bool> visited(n, false);
        vector<int> val(n);
        function<void(int)> dfs = [&](int u) {
            visited[u] = true;
            val[u] = 1;
            for (auto v : g[u]) {
                if (!visited[v]) {
                    dfs(v);
                    val[u] += val[v];
                }
            }
        };
        dfs(0);
        for (auto& r : roads) {
            res += (long long)val[r[0]] * val[r[1]];
        }
        return res;
    }
};