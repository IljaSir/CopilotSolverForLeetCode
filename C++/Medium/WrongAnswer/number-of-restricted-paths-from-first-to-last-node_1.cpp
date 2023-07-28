class Solution {
public:
    int countRestrictedPaths(int n, vector<vector<int>>& edges) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& e : edges) {
            graph[e[0]].push_back({e[1], e[2]});
            graph[e[1]].push_back({e[0], e[2]});
        }
        priority_queue<pair<int, int>> pq;
        pq.push({0, n});
        vector<int> dist(n + 1, INT_MAX);
        dist[n] = 0;
        while (!pq.empty()) {
            auto [d, u] = pq.top(); pq.pop();
            if (d > dist[u]) continue;
            for (auto [v, w] : graph[u]) {
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.push({dist[v], v});
                }
            }
        }
        vector<int> dp(n + 1, -1);
        function<int(int)> dfs = [&](int u) {
            if (u == n) return 1;
            if (dp[u] != -1) return dp[u];
            int res = 0;
            for (auto [v, w] : graph[u]) {
                if (dist[v] > dist[u]) {
                    res = (res + dfs(v)) % 1000000007;
                }
            }
            return dp[u] = res;
        };
        return dfs(1);
    }
};