class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0] - 1].push_back(edge[1] - 1);
            graph[edge[1] - 1].push_back(edge[0] - 1);
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        while (!pq.empty()) {
            auto [t, u] = pq.top();
            pq.pop();
            if (t > dist[u]) continue;
            for (auto v : graph[u]) {
                int wait = (t / change + 1) * change - t;
                int cost = t + wait + time;
                if (cost < dist[v]) {
                    dist[v] = cost;
                    pq.push({cost, v});
                }
            }
        }
        return dist[n - 1];
    }
};