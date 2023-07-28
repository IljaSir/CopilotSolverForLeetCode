class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        // dp[i][j] = min(dp[i][j], dp[i-][k] + prices[k][j])
        vector<vector<int>> dp(k + 1, vector<int>(n, INT_MAX));
        for (int i = 0; i <= k; ++i) {
            dp[i][src] = 0;
        }
        for (int i = 1; i <= k; ++i) {
            for (auto& flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (dp[i - 1][from] != INT_MAX) {
                    dp[i][to] = min(dp[i][to], dp[i - 1][from] + price);
                }
            }
        }
        return dp[k][dst] == INT_MAX ? -1 : dp[k][dst
                }
            }
        }
        return dist[dst] == INT_MAX ? -1 : dist[dst];
    }
};