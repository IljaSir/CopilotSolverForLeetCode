class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for(auto e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> ans(n, -1);
        vector<int> depth(n);
        vector<vector<int>> parent(51, vector<int>(n, -1));
        function<void(int, int)> dfs = [&](int u, int p) {
            parent[nums[u]][u] = p;
            for(int i = 1; i <= 50; i++) {
                if(parent[i][u] != -1) {
                    parent[i][u] = parent[i][parent[i][u]];
                }
            }
            for(auto v : g[u]) {
                if(v != p) {
                    depth[v] = depth[u] + 1;
                    dfs(v, u);
                }
            }
        };
        dfs(0, -1);
        function<int(int, int)> lca = [&](int u, int v) {
            if(depth[u] < depth[v]) {
                swap(u, v);
            }
            for(int i = 50; i >= 1; i--) {
                if(parent[i][u] != -1 && depth[parent[i][u]] >= depth[v]) {
                    u = parent[i][u];
                }
            }
            if(u == v) {
                return u;
            }
            for(int i = 50; i >= 1; i--) {
                if(parent[i][u] != -1 && parent[i][v] != -1 && parent[i][u] != parent[i][v]) {
                    u = parent[i][u];
                    v = parent[i][v];
                }
            }
            return parent[1][u];
        };
        for(int i = 1; i < n; i++) {
            ans[i] = lca(i, ans[i]);
        }
        return ans;
    }
};