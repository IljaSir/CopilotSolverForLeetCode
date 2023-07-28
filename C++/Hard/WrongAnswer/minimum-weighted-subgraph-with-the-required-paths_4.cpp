class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& edge: edges) {
            graph[edge[0]].emplace_back(edge[1], edge[2]);
        }
        vector<vector<long long>> dist(n, vector<long long>(n, INT_MAX));
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
            priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
            pq.emplace(0, i);
            while (!pq.empty()) {
                auto [d, u] = pq.top();
                pq.pop();
                if (d > dist[i][u]) {
                    continue;
                }
                for (auto& [v, w]: graph[u]) {
                    if (d + w < dist[i][v]) {
                        dist[i][v] = d + w;
                        pq.emplace(d + w, v);
                    }
                }
            }
        }
        long long ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (dist[src1][i] == INT_MAX or dist[src2][i] == INT_MAX or dist[dest][i] == INT_MAX) {
                continue;
            }
            ans = min(ans, dist[src1][i] + dist[src2][i] + dist[dest][i]);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};