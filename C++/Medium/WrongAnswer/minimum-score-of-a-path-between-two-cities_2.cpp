class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto r : roads) {
            graph[r[0]].push_back({r[1], r[2]});
            graph[r[1]].push_back({r[0], r[2]});
        }
        vector<int> dist(n + 1, INT_MAX);
        vector<int> visited(n + 1, 0);
        dist[1] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 1});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (visited[u]) continue;
            visited[u] = 1;
            for (auto [v, w] : graph[u]) {
                if (dist[v] > max(d, w)) {
                    dist[v] = max(d, w);
                    pq.push({dist[v], v});
                }
            }
        }
        return dist[n];
    }
};