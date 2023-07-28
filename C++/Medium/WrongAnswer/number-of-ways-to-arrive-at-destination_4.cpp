class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        const int mod = 1e9 + 7;
        vector<vector<pair<int, int>>> g(n);
        for (auto& road : roads) {
            g[road[0]].emplace_back(road[1], road[2]);
            g[road[1]].emplace_back(road[0], road[2]);
        }
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX / 2));
        vector<vector<int>> ways(n, vector<int>(n, 0));
        dist[0][0] = 0;
        ways[0][0] = 1;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        while (!pq.empty()) {
            auto [d, p] = pq.top();
            pq.pop();
            int u = p.first;
            int v = p.second;
            if (d > dist[u][v]) {
                continue;
            }
            for (auto& [w, t] : g[v]) {
                int nd = d + t;
                if (nd < dist[u][w]) {
                    dist[u][w] = nd;
                    ways[u][w] = ways[u][v];
                    pq.push({nd, {u, w}});
                } else if (nd == dist[u][w]) {
                    ways[u][w] = (ways[u][w] + ways[u][v]) % mod;
                }
            }
        }
        return ways[0][n - 1];
    }
};