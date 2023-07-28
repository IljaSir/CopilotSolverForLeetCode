class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto &e : edges) {
            graph[e[0]].push_back({e[1], time});
            graph[e[1]].push_back({e[0], time});
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<int> dist(n + 1, INT_MAX);
        pq.push({0, 1});
        dist[1] = 0;
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) {
                continue;
            }
            for (auto &[v, w] : graph[u]) {
                int t = d + w + (d + w) / change * change;
                if (t < dist[v]) {
                    dist[v] = t;
                    pq.push({t, v});
                }
            }
        }
        return dist[n];
    }
};