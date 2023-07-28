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
        return dp[k + 1][dst] == INF ? -1 : dp[k + 1][dst];
    }
};