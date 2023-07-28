class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> g(n);
        for (auto& road: roads) {
            g[road[0] - 1].push_back({road[1] - 1, road[2]});
            g[road[1] - 1].push_back({road[0] - 1, road[2]});
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto& [v, w]: g[u]) {
                if (dist[v] > max(dist[u], w)) {
                    dist[v] = max(dist[u], w);
                    pq.push({dist[v], v});
                }
            }
        }
        return dist[n - 1];
    }
};