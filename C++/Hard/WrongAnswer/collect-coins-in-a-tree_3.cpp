class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        int n = coins.size();
        vector<vector<int>> tree(n);
        for (auto& e : edges) {
            tree[e[0]].push_back(e[1]);
            tree[e[1]].push_back(e[0]);
        }
        vector<int> dp(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            dp[u] = coins[u];
            for (auto v : tree[u]) {
                if (v == p) continue;
                dfs(v, u);
                dp[u] += dp[v];
            }
        };
        dfs(0, -1);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == 0) continue;
            res += 2;
            for (auto j : tree[i]) {
                if (dp[j] > 0) {
                    res -= 2;
                    break;
                }
            }
        }
        return res;
    }
};