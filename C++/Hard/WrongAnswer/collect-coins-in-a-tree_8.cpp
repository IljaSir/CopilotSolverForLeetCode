class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        
        vector<vector<int>> G(coins.size());
        for (auto& e: edges) {
            G[e[0]].push_back(e[1]);
            G[e[1]].push_back(e[0]);
        }
        vector<int> dp(coins.size());
        function<void(int, int)> dfs = [&](int u, int p) {
            for (auto v: G[u]) {
                if (v == p) continue;
                dfs(v, u);
                dp[u] += dp[v];
            }
            dp[u] += coins[u];
        };
        dfs(0, -1);
        int ans = 0;
        for (int i = 0; i < coins.size(); ++i) {
            if (dp[i] == 0) continue;
            ans += 2 * (dp[i] - 1);
            if (i == 0) {
                ans += 2;
            } else {
                ans += 1;
            }
        }
        return ans;
    }
};