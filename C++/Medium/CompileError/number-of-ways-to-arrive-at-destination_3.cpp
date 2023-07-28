class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        vector<vector<vector<int>>> adj(n);
        for (auto& road: roads) {
            adj[road[0]].push_back({road[1], road[2]});
            adj[road[1]].push_back({road[0], road[2]});
        }
        vector<int> dist(n, INT_MAX);
        vector<int> cnt(n, 0);
        dist[0] = 0;
        cnt[0] = 1;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto [d, u] = q.top();
            q.pop();
            if (d > dist[u]) continue;
            for (auto& [v, w]: adj[u]) {
                if (dist[u] + w > dist[v]) continue;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    q.push({dist[v], v});
                }
                cnt[v] = (cnt[v] + cnt[u]) % (int)(1e9 + 7);
            }
        }
        return cnt[n - 1];
    }
};