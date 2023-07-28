class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        
        vector<vector<int>> tree(prevRoom.size());
        for (int i = 1; i < prevRoom.size(); ++i) {
            tree[prevRoom[i]].push_back(i);
        }
        vector<int> dp(prevRoom.size());
        return dfs(tree, dp, 0);
    }
    int dfs(vector<vector<int>>& tree, vector<int>& dp, int node) {
        if (dp[node] > 0) {
            return dp[node];
        }
        dp[node] = 1;
        for (int child: tree[node]) {
            dp[node] = (long long)dp[node] * (dfs(tree, dp, child) + 1) % 1000000007;
        }
        return dp[node];
    }
};