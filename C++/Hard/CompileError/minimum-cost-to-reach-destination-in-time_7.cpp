class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<int>> cost(n, vector<int>(maxTime+1, INT_MAX));
        cost[0][0] = passingFees[0];
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back({e[1], e[2]});
            graph[e[1]].push_back({e[0], e[2]});
        }
        
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({passingFees[0], 0, 0});
        while (!pq.empty()) {
            auto [c, u, t] = pq.top();
            pq.pop();
            if (u == n-1) return c;
            for (auto& [v, w] : graph[u]) {
                if (t+w > maxTime) continue;
                if (c + passingFees[v] < cost[v][t+w]) {
                    cost[v][t+w] = c + passingFees[v];
                    pq.push({cost[v][t+w], v, t+w});
                }
            }
        }
        return -1;
    }
};