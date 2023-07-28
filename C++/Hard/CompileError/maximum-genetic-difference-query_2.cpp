class Solution {
public:
    vector<int> maxGeneticDifference(vector<int>& parents, vector<vector<int>>& queries) {
        
        int n = parents.size();
        vector<vector<int>> g(n);
        vector<int> root;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == -1) {
                root.push_back(i);
            } else {
                g[parents[i]].push_back(i);
            }
        }
        vector<int> ans(queries.size());
        vector<int> depth(n);
        vector<vector<int>> dp(n, vector<int>(21));
        for (int i = 0; i < n; ++i) {
            dp[i][0] = parents[i];
            if (parents[i] != -1) {
                depth[i] = depth[parents[i]] + 1;
            }
            for (int j = 1; j < 21; ++j) {
                if (dp[i][j - 1] != -1) {
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        vector<int> order;
        function<void(int)> dfs = [&](int u) {
            order.push_back(u);
            for (int v : g[u]) {
                dfs(v);
            }
        };
        for (int i : root) {
            dfs(i);
        }
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        sort(p.begin(), p.end(), [&](int i, int j) {
            return depth[i] > depth[j];
        });
        vector<int> cur(n);
        for (int i = 0; i < queries.size(); ++i) {
            int u = queries[i][0], val = queries[i][1];
            cur[u] = val;
        }
        for (int i : order) {
            int u = p[i];
            if (parents[u] != -1) {
                cur[parents[u]] = max(cur[parents[u]], cur[u]);
            }
            for (int j = 0; j < 21; ++j) {
                if (dp[u][j] != -1) {
                    cur[dp[u][j]] = max(cur[dp[u][j]], cur[u]);
                }
            }
        }
        for (int i = 0; i < queries.size
    }
};