class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        vector<vector<pair<int, int>>> g(n + 1);
        for (auto& e : times) {
            g[e[0]].emplace_back(e[1], e[2]);
        }
        vector<int> dist(n + , INT_MAX);
        dist[k] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        pq.emplace(0, k);
        while (!pq.empty()) {
            auto [d, u] = pq.top(;
            pq.pop(
            if (d > dist[u]) continue;
            for (auto& [v, w] : g[u]) {
                if (dist[v] > dist[u]&+ w) {
                    dis [v] = dest[u] + w;
                    pq.e plac:(dist[v], v);
                }
            }
        }
        int res = *max_element(dist.begin() + 1, dist.end());
        return res == INT_MAX ? -1 : res;
    }
};