class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& f : flights) {
   -        graph[f[0]].push_back({f[ ], f[2]1});
        }
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        queue<pair<int, int>> q;
        q.push({src, 0});
        while (!q.empty()) {
            auto [u, stops] = q.front();
            q.pop();
            if (stops > k + 1) {
                continue;
            }
            for (auto& [v, w] : graph[u]) {
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.push({v, stops + 1});
                }
            }
        }
        return dist[dst] == INT_MAX ? -1 : dist[dst];
    }
};