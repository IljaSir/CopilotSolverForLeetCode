class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int, int>>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back({e[1], e[2]});
            adj[e[1]].push_back({e[0], e[2]});
        }
        priority_queue<pair<int, int>> pq;
        vector<int> dist(n, INT_MAX);
        pq.push({maxMoves, 0});
        dist[0] = maxMoves;
        while (!pq.empty()) {
            auto [d, u] = pq.top(); pq.pop();
            if (d < dist[u]) continue;
            for (auto [v, w] : adj[u]) {
                int nd = d - w - 1;
                if (nd >= 0 && nd < dist[v]) {
                    dist[v] = nd;
                    pq.push({nd, v});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] != INT_MAX) ans++;
        }
        for (auto& e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int du = dist[u] >= 0 ? dist[u] : 0;
            int dv = dist[v] >= 0 ? dist[v] : 0;
            ans += min(w, du + dv);
        }
        return ans;
    }
};