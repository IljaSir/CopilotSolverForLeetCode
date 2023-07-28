class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        long long INF = 1e18;
        vector<vector<pair<int, long long>>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back({e[1], e[2]});
        }
        vector<vector<long long>> dist(3, vector<long long>(n, INF));
        vector<vector<int>> par(3, vector<int>(n, -1));
        for (int i = 0; i < 3; ++i) {
            priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
            pq.push({0, i == 0 ? src1 : src2});
            dist[i][i == 0 ? src1 : src2] = 0;
            while (!pq.empty()) {
                auto [d, u] = pq.top();
                pq.pop();
                if (d > dist[i][u]) {
                    continue;
                }
                for (auto [v, w] : adj[u]) {
                    if (d + w < dist[i][v]) {
                        dist[i][v] = d + w;
                        par[i][v] = u;
                        pq.push({dist[i][v], v});
                    }
                }
            }
        }
        long long ans = INF;
        for (int i = 0; i < n; ++i) {
            if (dist[0][i] != INF && dist[1][i] != INF && dist[2][i] != INF) {
                ans = min(ans, dist[0][i] + dist[1][i] + dist[2][i]);
            }
        }
        return ans == INF ? -1 : ans;
    }
};