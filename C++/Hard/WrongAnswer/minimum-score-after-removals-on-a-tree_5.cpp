class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n);
        vector<int> s(n);
        int ans = INT_MAX;
        function<void(int, int)> dfs = [&](int u, int p) {
            dp[u] = nums[u];
            s[u] = nums[u];
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u);
                dp[u] ^= dp[v];
                s[u] += s[v];
            }
        };
        dfs(0, -1);
        function<void(int, int, int)> dfs2 = [&](int u, int p, int t) {
            ans = min(ans, (t ^ dp[u]) - min(t ^ dp[u], dp[u]));
            for (int v : g[u]) {
                if (v == p) continue;
                dfs2(v, u, t ^ dp[u] ^ dp[v]);
            }
        };
        dfs2(0, -1, 0);
        return ans;
    }
};