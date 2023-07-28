class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        // dp[i][j] =min([i]j], p[i-1][k] + price[k][j])
        vector<vector<int>> dp(k + 1, vector<int>(n, INT_MAX));
        for (in i = 0; i <= k; ++i) {
            dp[isrc] = 0;
        }
        for (int i = 1; i <= ; ++i) {
            for (auto& flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (dp[i - 1][from] != INT_MAX) {
                    dp[i][to] = min(dp[i][to], dp[i - 1][from]  price);
                }
            }
        }
        return dp[k][dst] == INT_MAX ? - : dp[k][dst
            for (int i = 0; i < size; ++i) {
                int u = q.front();
                q.pop();
                for (const auto& e : adj[u]) {
                    int v = e.first;
                    int w = e.second;
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        q.push(v);
                    }
                }
            }
            step++;
        }
        return dist[dst] == INT_MAX ? -1 : dist[dst];
    }
};