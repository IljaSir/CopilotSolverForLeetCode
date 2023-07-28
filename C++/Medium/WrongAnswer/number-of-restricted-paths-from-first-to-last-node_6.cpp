class Solution {
public:
    int countRestrictedPaths(int n, vector<vector<int>>& edges) {
        
        vector<vector<pair<int, int>>> g(n);
        for (auto e : edges) {
            g[e[0] - 1].push_back({e[1] - 1, e[2]});
            g[e[1] - 1].push_back({e[0] - 1, e[2]});
        }
        vector<int> dis(n, INT_MAX);
        dis[n - 1] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, n - 1});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dis[u]) continue;
            for (auto [v, w] : g[u]) {
                if (dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    pq.push({dis[v], v});
                }
            }
        }
        vector<int> dp(n, -1);
        function<int(int)> dfs = [&](int u) {
            if (u == n - 1) return 1;
            if (dp[u] != -1) return dp[u];
            dp[u] = 0;
            for (auto [v, w] : g[u]) {
                if (dis[v] > dis[u]) {
                    dp[u] = (dp[u] + dfs(v)) % 1000000007;
                }
            }
            return dp[u];
        };
        return dfs(0);
    }
};