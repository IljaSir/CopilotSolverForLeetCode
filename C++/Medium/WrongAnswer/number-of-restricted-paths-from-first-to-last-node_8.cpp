class Solution {
public:
    int countRestrictedPaths(int n, vector<vector<int>>& edges) {
        
        vector<vector<pair<int,int>>> graph(n+1);
        for (auto &edge: edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        vector<int> dist(n+1, INT_MAX);
        dist[n] = 0;
        priority_queue<pair<int,int>> pq;
        pq.push({0, n});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto &e: graph[u]) {
                int v = e.first;
                int w = e.second;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.push({dist[v], v});
                }
            }
        }
        vector<int> dp(n+1, 0);
        dp[n] = 1;
        function<void(int)> dfs = [&](int u) {
            for (auto &e: graph[u]) {
                int v = e.first;
                int w = e.second;
                if (dist[v] > dist[u]) {
                    if (dp[v] == 0) {
                        dfs(v);
                    }
                    dp[u] = (dp[u] + dp[v]) % 1000000007;
                }
            }
        };
        dfs(1);
        return dp[1];
    }
};