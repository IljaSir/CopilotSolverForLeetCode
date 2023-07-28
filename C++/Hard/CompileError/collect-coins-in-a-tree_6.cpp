class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        vector<vector<int>> tree(coins.size());
        for (auto& e : edges) {
            tree[e[0]].push_back(e[1]);
            tree[e[1]].push_back(e[0]);
        }
        vector<int> dp(coins.size(), 0);
        int res = 0;
        dfs(tree, coins, dp, 0, -1, res);
        return res;
    }
};