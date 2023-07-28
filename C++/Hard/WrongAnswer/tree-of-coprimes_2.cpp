class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> ans(n, -1);
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> fa(n, vector<int>(51, -1));
        vector<int> depth(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            int d = 0;
            for (int i = 2; i <= 50; i++) {
                if (nums[u] % i == 0) {
                    int v = fa[u][i];
                    if (v != -1 && depth[v] > d) {
                        d = depth[v];
                        ans[u] = v;
                    }
                }
            }
            depth[u] = d + 1;
            for (int i = 2; i <= 50; i++) {
                if (nums[u] % i == 0) {
                    fa[u][i] = u;
                } else {
                    fa[u][i] = p == -1 ? -1 : fa[p][i];
                }
            }
            for (int v : g[u]) {
                if (v != p) {
                    dfs(v, u);
                }
            }
        };
        dfs(0, -1);
        return ans;
    }
};