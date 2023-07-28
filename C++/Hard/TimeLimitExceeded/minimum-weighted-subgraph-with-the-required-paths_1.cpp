class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].emplace_back(e[1], e[2]);
        }
        vector<vector<long long>> dist(n, vector<long long>(n, INT64_MAX));
        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
            priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
            pq.emplace(0, i);
            while (!pq.empty()) {
                auto [d, u] = pq.top();
                pq.pop();
                if (d > dist[i][u]) continue;
                for (auto [v, w] : graph[u]) {
                    if (d + w < dist[i][v]) {
                        dist[i][v] = d + w;
                        pq.emplace(d + w, v);
                    }
                }
            }
        }
        long long ans = INT64_MAX;
        for (int i = 0; i < n; ++i) {
            if (dist[src1][i] != INT64_MAX && dist[src2][i] != INT64_MAX && dist[i][dest] != INT64_MAX) {
                ans = min(ans, dist[src1][i] + dist[src2][i] + dist[i][dest]);
            }
        }
        return ans == INT64_MAX ? -1 : ans;
    }
};