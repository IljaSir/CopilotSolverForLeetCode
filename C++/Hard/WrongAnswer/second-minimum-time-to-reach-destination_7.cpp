class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (const auto& edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].emplace_back(v, 0);
            graph[v].emplace_back(u, 0);
        }
        for (int i = 1; i <= n; ++i) {
            int cycle = i * change;
            int k = (time - 1) / cycle;
            int remain = time - k * cycle;
            int t = remain > 0 ? remain : time;
            for (auto& p : graph[i]) {
                p.second = t;
            }
        }
        vector<int> dist(n + 1, INT_MAX);
        dist[1] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.emplace(0, 1);
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) {
                continue;
            }
            for (const auto& [v, t] : graph[u]) {
                int d2 = d + t;
                if (d2 < dist[v]) {
                    dist[v] = d2;
                    pq.emplace(d2, v);
                }
            }
        }
        return dist[n];
    }
};