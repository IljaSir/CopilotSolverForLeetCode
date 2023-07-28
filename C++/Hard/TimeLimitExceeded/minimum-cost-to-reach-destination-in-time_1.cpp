class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dist(n, vector<int>(maxTime + 1, INT_MAX));
        dist[0][0] = passingFees[0];
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({passingFees[0], 0, 0});
        while (!pq.empty()) {
            auto t = pq.top(); pq.pop();
            int d = t[0], u = t[1], time = t[2];
            if (d > dist[u][time]) continue;
            for (auto& e : g[u]) {
                int v = e.first, w = e.second;
                if (time + w <= maxTime) {
                    if (dist[v][time + w] > d + passingFees[v]) {
                        dist[v][time + w] = d + passingFees[v];
                        pq.push({dist[v][time + w], v, time + w});
                    }
                }
            }
        }
        int res = INT_MAX;
        for (int i = 0; i <= maxTime; ++i) {
            res = min(res, dist[n - 1][i]);
        }
        return res == INT_MAX ? -1 : res;
    }
};