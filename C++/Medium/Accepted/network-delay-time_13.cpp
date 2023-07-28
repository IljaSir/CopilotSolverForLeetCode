class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        // Dijkstra
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& time: times) {
            graph[time[0]].push_back({time[1], time[2]});
        }
        vector<int> dist(n + 1, INT_MAX);
        dist[k] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, k});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (dist[u] < d) continue;
            for (auto& [v, w]: graph[u]) {
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.push({dist[v], v});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if (dist[i] == INT_MAX) return -1;
            res = max(res, dist[i]);
        }
        return res;
    }
};