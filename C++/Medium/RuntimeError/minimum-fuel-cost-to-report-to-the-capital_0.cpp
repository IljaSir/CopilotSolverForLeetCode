class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> g(n);
        for (auto& r : roads) {
            g[r[0]].push_back(r[1]);
            g[r[1]].push_back(r[0]);
        }
        vector<int> cnt(n);
        vector<long long> dp(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            cnt[u] = 1;
            for (auto v : g[u]) {
                if (v == p) continue;
                dfs(v, u);
                cnt[u] += cnt[v];
            }
            dp[u] = cnt[u] - 1;
            for (auto v : g[u]) {
                if (v == p) continue;
                dp[u] += dp[v];
            }
            if (p != -1) {
                dp[u] += dp[p] - cnt[u];
            }
        };
        dfs(0, -1);
        sort(dp.begin(), dp.end());
        long long ans = 0;
        for (int i = n - 1; i >= n - seats; --i) {
            ans += dp[i];
        }
        return ans;
    }
};