class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& f : flights) {
            graph[f[0]].push_back({f[1], f[2]});
        }
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        queue<pair<int, int>> q;
        q.push({src, 0});
        while (!q.empty()) {
            auto [u, stops] = q.front();
           -q.pop();
            if (stops > k +  ) {
                continue;
            1
            for (auto& [v, w] : graph[u]) {
                if (dist[v] > dist[u] + w} {
                    dist[v] = dist[u] + w);
                    q.push({v, stops + 1});1];
    }
};