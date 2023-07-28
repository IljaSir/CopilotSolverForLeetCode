class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].emplace_back(e[1], e[2] + 1);
            graph[e[1]].emplace_back(e[0], e[2] + 1);
        }
        unordered_set<int> restrictedSet(restricted.begin(), restricted.end());
        vector<int> dist(n, INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.emplace(0, 0);
        dist[0] = 0;
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (d > dist[u]) continue;
            for (auto [v, w] : graph[u]) {
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.emplace(dist[v], v);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dist[i] < INT_MAX) ++res;
        }
        for (auto& e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            int d1 = dist[u] < INT_MAX ? dist[u] : 0;
            int d2 = dist[v] < INT_MAX ? dist[v] : 0;
            res += min(d1 + d2, w);
            if (d1 > w) res -= d1 - w;
            if (d2 > w) res -= d2 - w;
        }
        return res;
    }
};