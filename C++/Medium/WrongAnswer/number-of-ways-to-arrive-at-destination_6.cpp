class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        int mod = 1e9 + 7;
        vector<vector<pair<int, int>>> graph(n);
        for (auto& r: roads) {
            graph[r[0]].push_back({r[1], r[2]});
            graph[r[1]].push_back({r[0], r[2]});
        }
        vector<long long> dist(n, 1e18);
        vector<int> ways(n);
        dist[0] = 0;
        ways[0] = 1;
        priority_queue<pair<int, int>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto [v, w]: graph[u]) {
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.push({dist[v], v});
                    ways[v] = ways[u];
                } else if (dist[v] == dist[u] + w) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
};