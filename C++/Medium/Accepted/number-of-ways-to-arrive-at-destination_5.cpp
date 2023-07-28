class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        const int MOD = 1e9 + 7;
        vector<vector<pair<int, int>>> g(n);
        for (auto& road: roads) {
            g[road[0]].push_back({road[1], road[2]});
            g[road[1]].push_back({road[0], road[2]});
        }
        vector<long> dist(n, LONG_MAX);
        vector<int> ways(n);
        dist[0] = 0;
        ways[0] = 1;
        priority_queue<pair<long, int>, vector<pair<long, int>>, greater<pair<long, int>>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto& [v, w]: g[u]) {
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.push({dist[v], v});
                } else if (dist[v] == dist[u] + w) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
};