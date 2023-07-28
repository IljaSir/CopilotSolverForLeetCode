class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back({edge[1], edge[2] + 1});
            graph[edge[1]].push_back({edge[0], edge[2] + 1});
        }
        priority_queue<pair<int, int>> pq;
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        pq.push({0, 0});
        while (!pq.empty()) {
            auto [d, node] = pq.top();
            pq.pop();
            if (d > dist[node]) {
                continue;
            }
            for (auto [nei, w] : graph[node]) {
                if (dist[node] + w < dist[nei]) {
                    dist[nei] = dist[node] + w;
                    pq.push({dist[nei], nei});
                }
            }
        }
        int res = 0;
        for (int d : dist) {
            if (d <= maxMoves) {
                ++res;
            }
        }
        for (auto& edge : edges) {
            int d1 = dist[edge[0]] <= maxMoves ? dist[edge[0]] : 0;
            int d2 = dist[edge[1]] <= maxMoves ? dist[edge[1]] : 0;
            res += min(edge[2], d1 + d2);
        }
        return res;
    }
};