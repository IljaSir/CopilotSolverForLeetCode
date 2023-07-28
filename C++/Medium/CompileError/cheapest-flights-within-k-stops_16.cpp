class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        const int INF = 1e9;
        vector<vector<pair<int, int>>> graph(n);
        for (auto& flight : flights) {
            graph[flight[0]].emplace_back(flight[1], flight[2]);
        }
        vector<vector<int>> dp(k + 2, vector<int>(n, INF));
        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                for (auto& flight : graph[j]) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][flight.first] + flight.second);
                }
            }
        }
        return dp[k + 1][dst] == INF ? -1 : dp[k + 1][dst][flight[0]].push_back({flight[1], flight[2]});
        }
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> q;
        q.push({0, src, k + 1});
        while (!q.empty()) {
            auto [cost, u, stops] = q.top();
            q.pop();
            if (u == dst) {
                return cost;
            }
            if (stops > 0) {
                for (auto& [v, w] : graph[u]) {
                    if (dist[v] > cost + w) {
                        dist[v] = cost + w;
                        q.push({cost + w, v, stops - 1});
                    }
                }
            }
        }
        return -1;
    }
};