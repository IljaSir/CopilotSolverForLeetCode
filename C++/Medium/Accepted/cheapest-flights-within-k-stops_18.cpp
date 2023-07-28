class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int,int>>> graph(n);
        for(auto f: flights) graph[f[0]].push_back({f[1],f[2]});
        
        vector<vector<int>> dp(n, vector<int>(k+2, INT_MAX));
        dp[src][0] = 0;
        for(int i = 1; i <= k+1; i++){
            dp[src][i] = 0;
            for(auto f: flights){
                int from = f[0], to = f[1], cost = f[2];
                if(dp[from][i-1] != INT_MAX) dp[to][i] = min(dp[to][i], dp[from][i-1] + cost);
            }
        }
        return dp[dst][k+1] == INT_MAX ? -1 : dp[dst][k+1];
    }
};