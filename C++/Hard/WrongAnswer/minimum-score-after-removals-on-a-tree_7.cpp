class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            g[u].push_back(v);
            g[v].push_back(u);
        }
        vector<int> sz(n);
        vector<int> val(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            val[u] = nums[u];
            for (int v : g[u]) {
                if (v != p) {
                    dfs(v, u);
                    sz[u] += sz[v];
                    val[u] ^= val[v];
                }
            }
        };
        dfs(0, -1);
        int ans = INT_MAX;
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            if (sz[u] > sz[v]) swap(u, v);
            ans = min(ans, (val[u] ^ val[v]));
        }
        return ans;
    }
};