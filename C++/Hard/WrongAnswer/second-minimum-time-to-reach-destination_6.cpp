class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<pair<int, int>>> adj(n + 1);
        for (auto& edge : edges) {
            adj[edge[0]].push_back({edge[1], time});
            adj[edge[1]].push_back({edge[0], time});
        }
        vector<int> dist(n + 1, INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 1});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d >= dist[u]) continue;
            dist[u] = d;
            for (auto& [v, t] : adj[u]) {
                int cycle = (d + t) / change;
                int next = cycle * change + change;
                pq.push({next, v});
            }
        }
        return dist[n];
    }
};