class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back({e[1], e[2]});
        }
        vector<vector<long long>> dist(n, vector<long long>(n, LLONG_MAX));
        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
            priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
            pq.push({0, i});
            while (!pq.empty()) {
                auto [d, u] = pq.top();
                pq.pop();
                if (d > dist[i][u]) {
                    continue;
                }
                for (auto [v, w] : graph[u]) {
                    if (d + w < dist[i][v]) {
                        dist[i][v] = d + w;
                        pq.push({dist[i][v], v});
                    }
                }
            }
        }
        if (dist[src1][dest] == LLONG_MAX || dist[src2][dest] == LLONG_MAX) {
            return -1;
        }
        long long ans = dist[src1][dest] + dist[src2][dest];
        for (int i = 0; i < n; ++i) {
            if (dist[src1][i] != LLONG_MAX && dist[src2][i] != LLONG_MAX && dist[i][dest] != LLONG_MAX) {
                ans = min(ans, dist[src1][i] + dist[src2][i] + dist[i][dest]);
            }
        }
        return ans;
    }
};