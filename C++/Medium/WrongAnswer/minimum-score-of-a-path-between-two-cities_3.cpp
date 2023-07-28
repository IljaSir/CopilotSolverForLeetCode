class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> g(n);
        for (auto& r: roads) {
            g[r[0]-1].push_back({r[1]-1, r[2]});
            g[r[1]-1].push_back({r[0]-1, r[2]});
        }
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            if (p.first != dist[p.second]) continue;
            for (auto& e: g[p.second]) {
                if (dist[e.first] > max(dist[p.second], e.second)) {
                    dist[e.first] = max(dist[p.second], e.second);
                    pq.push({dist[e.first], e.first});
                }
            }
        }
        return dist[n-1];
    }
};