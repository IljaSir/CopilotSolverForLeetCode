class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> graph(n);
        for (auto edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].push_back({v, w});
            graph[v].push_back({u, w});
        }
        vector<vector<int>> dist(n, vector<int>(maxTime + 1, INT_MAX));
        dist[0][0] = passingFees[0];
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({passingFees[0], 0, 0});
        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            int cost = top[0], u = top[1], time = top[2];
            if (u == n - 1) return cost;
            for (auto nei : graph[u]) {
                int v = nei.first, w = nei.second;
                if (time + w <= maxTime && dist[v][time + w] > cost + passingFees[v]) {
                    dist[v][time + w] = cost + passingFees[v];
                    pq.push({dist[v][time + w], v, time + w});
                }
            }
        }
        return -1;
    }
};