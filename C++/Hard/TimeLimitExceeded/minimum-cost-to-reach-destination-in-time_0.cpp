class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, INT_MAX));
        dp[0][0] = passingFees[0];
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({passingFees[0], 0, 0});
        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            int cost = top[0], u = top[1], time = top[2];
            if (dp[u][time] < cost) continue;
            for (auto& e : g[u]) {
                int v = e.first, t = e.second;
                if (time + t <= maxTime) {
                    int c = cost + passingFees[v];
                    if (c < dp[v][time + t]) {
                        dp[v][time + t] = c;
                        pq.push({c, v, time + t});
                    }
                }
            }
        }
        int res = INT_MAX;
        for (int i = 0; i <= maxTime; ++i) {
            res = min(res, dp[n - 1][i]);
        }
        return res == INT_MAX ? -1 : res;
    }
};