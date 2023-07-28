class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u].push_back({v, w});
            graph[v].push_back({u, w});
        }
        vector<int> dist(n, INT_MAX);
        vector<int> ways(n, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        dist[0] = 0;
        ways[0] = 1;
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto [v, w] : graph[u]) {
                if (dist[v] == d + w) {
                    ways[v] = (ways[v] + ways[u]) % 1000000007;
                } else if (dist[v] > d + w) {
                    dist[v] = d + w;
                    ways[v] = ways[u];
                    pq.push({dist[v], v});
                }
            }
        }
        return ways[n - 1];
    }
};