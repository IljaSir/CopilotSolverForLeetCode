class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<int> g[n];
        for(auto e : edges){
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, 0);
        vector<int> visited(n, 0);
        dfs(0, g, coins, dp, visited);
        return dp[0];
    }
    void dfs(int v, vector<int> g[], vector<int>& coins, vector<int>& dp, vector<int>& visited){
        visited[v] = 1;
        for(auto u : g[v]){
            if(!visited[u]){
                dfs(u, g, coins, dp, visited);
                dp[v] += dp[u] + coins[u];
            }
        }
    }
};