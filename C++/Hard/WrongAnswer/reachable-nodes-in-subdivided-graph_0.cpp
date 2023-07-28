class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back({e[1], e[2]});
            graph[e[1]].push_back({e[0], e[2]});
        }
        priority_queue<pair<int, int>> pq;
        pq.push({maxMoves, 0});
        vector<int> dist(n, -1);
        while (!pq.empty()) {
            int d = pq.top().first, node = pq.top().second;
            pq.pop();
            if (dist[node] != -1) continue;
            dist[node] = d;
            for (auto& e : graph[node]) {
                int v = e.first, w = e.second;
                if (dist[v] == -1 && d > w) pq.push({d - w - 1, v});
            }
        }
        int ans = 0;
        for (int d : dist) if (d >= 0) ans++;
        for (auto& e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int du = dist[u], dv = dist[v];
            if (du >= 0 && dv >= 0) {
                ans += min(du + dv, w);
            } else if (du >= 0 || dv >= 0) {
                ans += min(du + dv + w, w);
            }
        }
        return ans;
    }
};