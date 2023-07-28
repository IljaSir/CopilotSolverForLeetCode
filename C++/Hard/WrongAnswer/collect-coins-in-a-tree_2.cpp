class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> dp(n, 0);
        dfs(graph, coins, dp, 0, -1);
        return dp[0];
    }
    
    void dfs(vector<vector<int>>& graph, vector<int>& coins, vector<int>& dp, int u, int parent) {
        dp[u] = coins[u];
        for (int v : graph[u]) {
            if (v != parent) {
                dfs(graph, coins, dp, v, u);
                dp[u] += dp[v];
            }
        }
        if (dp[u] == 0) {
            dp[u] = -1;
        } else if (dp[u] == 1) {
            dp[u] = 1;
        } else {
            dp[u] = 2;
        }
    }
};