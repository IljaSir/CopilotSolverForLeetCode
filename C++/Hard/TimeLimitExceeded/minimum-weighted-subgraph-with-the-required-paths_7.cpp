class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int,int>>> g(n);
        for (auto e : edges) {
            g[e[0]].emplace_back(e[1], e[2]);
        }
        vector<vector<long long>> dist(n, vector<long long>(n, LONG_LONG_MAX));
        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
            priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
            pq.emplace(0, i);
            while (!pq.empty()) {
                auto p = pq.top();
                pq.pop();
                if (p.first > dist[i][p.second]) continue;
                for (auto e : g[p.second]) {
                    if (dist[i][p.second] + e.second < dist[i][e.first]) {
                        dist[i][e.first] = dist[i][p.second] + e.second;
                        pq.emplace(dist[i][e.first], e.first);
                    }
                }
            }
        }
        long long res = LONG_LONG_MAX;
        for (int i = 0; i < n; ++i) {
            if (dist[src1][i] != LONG_LONG_MAX && dist[src2][i] != LONG_LONG_MAX && dist[i][dest] != LONG_LONG_MAX) {
                res = min(res, dist[src1][i] + dist[src2][i] + dist[i][dest]);
            }
        }
        return res == LONG_LONG_MAX ? -1 : res;
    }
};