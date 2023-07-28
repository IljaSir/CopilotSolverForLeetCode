class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        int n = amount.size();
        vector<vector<int>> tree(n);
        for (auto& edge: edges) {
            tree[edge[0]].push_back(edge[1]);
            tree[edge[1]].push_back(edge[0]);
        }
        vector<int> dp(n, INT_MIN);
        dp[0] = 0;
        dfs(tree, 0, -1, dp, amount, bob);
        return dp[bob];
    }
    void dfs(vector<vector<int>>& tree, int node, int parent, vector<int>& dp, vector<int>& amount, int bob) {
        for (int child: tree[node]) {
            if (child != parent) {
                dfs(tree, child, node, dp, amount, bob);
                dp[node] = max(dp[node], dp[child] + amount[node]);
            }
        }
        if (node != bob) dp[node] -= amount[node] / 2;
    }
};