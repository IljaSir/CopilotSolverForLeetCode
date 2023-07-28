class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& road : roads) {
            graph[road[0]].push_back({road[1], road[2]});
            graph[road[1]].push_back({road[0], road[2]});
        }
        vector<int> dist(n + 1, INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 1});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (dist[u] < d) continue;
            for (auto& [v, w] : graph[u]) {
                if (dist[v] > max(d, w)) {
                    dist[v] = max(d, w);
                    pq.push({dist[v], v});
                }
            }
        }
        return dist[n];
    }
};