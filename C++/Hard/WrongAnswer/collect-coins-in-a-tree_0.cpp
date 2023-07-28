class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> cost(n, 0);
        vector<int> visited(n, 0);
        dfs(0, adj, coins, cost, visited);
        return cost[0];
    }
    void dfs(int u, vector<vector<int>>& adj, vector<int>& coins, vector<int>& cost, vector<int>& visited) {
        visited[u] = 1;
        for (int v : adj[u]) {
            if (visited[v]) continue;
            dfs(v, adj, coins, cost, visited);
            cost[u] += cost[v] + coins[v];
        }
    }
};