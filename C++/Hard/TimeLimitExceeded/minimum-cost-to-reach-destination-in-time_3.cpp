class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back({e[1], e[2]});
            adj[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, INT_MAX));
        dp[0][0] = passingFees[0];
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({passingFees[0], 0, 0});
        while (!pq.empty()) {
            auto v = pq.top();
            pq.pop();
            int c = v[0], u = v[1], t = v[2];
            if (u == n - 1) {
                return c;
            }
            if (t + 1 > maxTime) {
                continue;
            }
            for (auto& e : adj[u]) {
                int v = e.first, w = e.second;
                if (t + w <= maxTime && dp[v][t + w] > c + passingFees[v]) {
                    dp[v][t + w] = c + passingFees[v];
                    pq.push({dp[v][t + w], v, t + w});
                }
            }
        }
        return -1;
    }
};