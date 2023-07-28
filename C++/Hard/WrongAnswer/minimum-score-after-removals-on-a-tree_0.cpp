class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> f(n);
        function<void(int, int)> dfs = [&](int u, int fa) {
            f[u] = nums[u];
            for (auto v : g[u]) {
                if (v == fa) continue;
                dfs(v, u);
                f[u] ^= f[v];
            }
        };
        dfs(0, -1);
        int ans = f[0];
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            ans = min(ans, f[u] ^ f[v] ^ (f[u] ^ f[v] ^ nums[u] ^ nums[v]));
        }
        return ans;
    }
};