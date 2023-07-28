class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> ans(n, -1);
        vector<vector<int>> dp(n, vector<int>(51, -1));
        function<void(int, int)> dfs = [&](int u, int fa) {
            int maxd = -1;
            for (int i = 1; i <= 50; ++i) {
                if (__gcd(nums[u], i) != 1) continue;
                if (dp[u][i] != -1 && maxd < dp[u][i]) {
                    ans[u] = dp[u][i];
                    maxd = dp[u][i];
                }
            }
            for (int i = 1; i <= 50; ++i) {
                dp[u][i] = max(dp[u][i], dp[fa][i]);
            }
            dp[u][nums[u]] = u;
            for (int v : g[u]) {
                if (v == fa) continue;
                dfs(v, u);
            }
        };
        dfs(0, 0);
        return ans;
    }
};