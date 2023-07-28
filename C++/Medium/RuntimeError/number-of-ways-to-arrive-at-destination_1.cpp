class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : roads) {
            graph[e[0]].push_back({e[1], e[2]});
            graph[e[1]].push_back({e[0], e[2]});
        }
        vector<long long> dist(n, INT_MAX);
        vector<int> ways(n, 0);
        dist[0] = 0;
        ways[0] = 1;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto& [v, w] : graph[u]) {
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    ways[v] = ways[u];
                    pq.push({dist[v], v});
                } else if (d + w == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % 1000000007;
                }
            }
        }
        return ways[n - 1];
    }
};