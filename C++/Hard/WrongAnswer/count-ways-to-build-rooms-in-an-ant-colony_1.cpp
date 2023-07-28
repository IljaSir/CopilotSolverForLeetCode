class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        
        int n = prevRoom.size();
        vector<vector<int>> adj(n);
        for (int i = 1; i < n; ++i) {
            adj[prevRoom[i]].push_back(i);
        }
        vector<int> dp(n);
        dfs(adj, dp, 0);
        return dp[0];
    }
    void dfs(vector<vector<int>>& adj, vector<int>& dp, int u) {
        dp[u] = 1;
        for (auto v : adj[u]) {
            dfs(adj, dp, v);
            dp[u] = (dp[u] * 1LL * (dp[v] + 1)) % 1000000007;
        }
    }
};