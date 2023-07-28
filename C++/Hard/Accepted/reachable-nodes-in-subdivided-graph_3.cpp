class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e: edges) {
            graph[e[0]].push_back({e[1], e[2] + 1});
            graph[e[1]].push_back({e[0], e[2] + 1});
        }
        priority_queue<pair<int, int>> pq;
        pq.push({maxMoves, 0});
        vector<int> dist(n, -1);
        while (!pq.empty()) {
            auto [d, node] = pq.top();
            pq.pop();
            if (dist[node] != -1) continue;
            dist[node] = d;
            for (auto [nei, w]: graph[node]) {
                if (dist[nei] == -1 && d >= w) {
                    pq.push({d - w, nei});
                }
            }
        }
        int res = 0;
        for (auto d: dist) {
            if (d != -1) res++;
        }
        for (auto& e: edges) {
            int a = dist[e[0]] >= 0 ? dist[e[0]] : 0;
            int b = dist[e[1]] >= 0 ? dist[e[1]] : 0;
            res += min(a + b, e[2]);
        }
        return res;
    }
};