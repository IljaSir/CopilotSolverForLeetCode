class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> ans(n, -1);
        vector<vector<int>> adj(n);
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> depth(n, 0);
        function<void(int, int)> dfs = [&](int x, int p) {
            if (p != -1) depth[x] = depth[p] + 1;
            for (int y: adj[x]) {
                if (y == p) continue;
                dfs(y, x);
            }
        };
        dfs(0, -1);
        vector<vector<int>> dp(n, vector<int>(51, -1));
        function<void(int, int)> dfs2 = [&](int x, int p) {
            int u = nums[x];
            for (int v = 1; v <= 50; ++v) {
                if (__gcd(u, v) == 1) {
                    dp[x][v] = x;
                    if (p != -1 && dp[p][v] != -1) {
                        if (depth[dp[p][v]] > depth[dp[x][v]]) {
                            dp[x][v] = dp[p][v];
                        }
                    }
                } else {
                    dp[x][v] = -1;
                    if (p != -1) dp[x][v] = dp[p][v];
                }
            }
            for (int y: adj[x]) {
                if (y == p) continue;
                dfs2(y, x);
            }
        };
        dfs2(0, -1);
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= 50; ++j) {
                if (dp[i][j] != -1 && dp[i][j] != i) {
                    ans[i] = dp[i][j];
                    break;
                }
            }
        }
        return ans;
    }
};