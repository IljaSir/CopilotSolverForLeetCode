class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<vector<int>> tree(n);
        for (auto edge: edges) {
            tree[edge[0]].push_back(edge[1]);
            tree[edge[1]].push_back(edge[0]);
        }
        vector<int> dp(n, 0);
        dfs(tree, dp, 0, -1);
        return dp[0];
    }
    void dfs(vector<vector<int>>& tree, vector<int>& dp, int root, int parent) {
        dp[root] = coins[root];
        for (auto child: tree[root]) {
            if (child == parent) continue;
            dfs(tree, dp, child, root);
            dp[root] += dp[child];
        }
        dp[root] -= 1;
    }
};