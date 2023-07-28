class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n), dp2(n);
        dfs(0, -1, g, nums, dp);
        dfs2(0, -1, g, nums, dp, dp2);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, dp[i] ^ dp2[i]);
        }
        return ans;
    }
    void dfs(int u, int fa, vector<vector<int>>& g, vector<int>& nums, vector<int>& dp) {
        dp[u] = nums[u];
        for (int v : g[u]) {
            if (v == fa) continue;
            dfs(v, u, g, nums, dp);
            dp[u] ^= dp[v];
        }
    }
    void dfs2(int u, int fa, vector<vector<int>>& g, vector<int>& nums, vector<int>& dp, vector<int>& dp2) {
        if (fa != -1) {
            dp2[u] = dp2[fa] ^ dp[u] ^ dp2[u];
        }
        for (int v : g[u]) {
            if (v == fa) continue;
            dfs2(v, u, g, nums, dp, dp2);
        }
    }
};