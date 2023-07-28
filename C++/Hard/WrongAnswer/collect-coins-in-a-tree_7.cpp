class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        vector<vector<int>> adjList(coins.size());
        for (auto edge : edges) {
            adjList[edge[0]].push_back(edge[1]);
            adjList[edge[1]].push_back(edge[0]);
        }
        int res = 0;
        vector<int> dp(coins.size(), 0);
        function<void(int, int)> dfs = [&](int node, int parent) {
            for (auto adj : adjList[node]) {
                if (adj == parent) continue;
                dfs(adj, node);
                dp[node] += dp[adj];
            }
            dp[node] += coins[node];
            res += abs(dp[node]);
        };
        dfs(0, -1);
        return res;
    }
};