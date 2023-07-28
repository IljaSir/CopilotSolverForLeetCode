class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<long long> sum(n), cnt(n), ans(n);
        function<void(int, int)> dfs = [&](int u, int fa) {
            sum[u] = price[u];
            cnt[u] = 1;
            for (int v : g[u]) {
                if (v == fa) continue;
                dfs(v, u);
                sum[u] += sum[v];
                cnt[u] += cnt[v];
            }
        };
        dfs(0, -1);
        function<void(int, int)> dfs2 = [&](int u, int fa) {
            ans[u] = sum[u];
            for (int v : g[u]) {
                if (v == fa) continue;
                long long sumU = sum[u], cntU = cnt[u];
                sum[u] -= sum[v];
                cnt[u] -= cnt[v];
                sum[v] += sum[u];
                cnt[v] += cnt[u];
                dfs2(v, u);
                sum[u] = sumU;
                cnt[u] = cntU;
                sum[v] -= sum[u];
                cnt[v] -= cnt[u];
            }
        };
        dfs2(0, -1);
        long long res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, ans[i] * (cnt[0] - cnt[i]) - (sum[0] - sum[i]) * cnt[i]);
        }
        return res;
    }
};