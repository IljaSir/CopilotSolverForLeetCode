class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> sz(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            for (int v : adj[u]) {
                if (v == p) continue;
                dfs(v, u);
                sz[u] += sz[v];
            }
        };
        dfs(0, -1);
        int ans = INT_MAX;
        function<int(int, int)> dfs2 = [&](int u, int p) {
            int ret = nums[u];
            for (int v : adj[u]) {
                if (v == p) continue;
                ret ^= dfs2(v, u);
            }
            if (p != -1) {
                ans = min(ans, ret ^ dfs2(p, u));
            }
            return ret;
        };
        dfs2(0, -1);
        return ans;
    }
};