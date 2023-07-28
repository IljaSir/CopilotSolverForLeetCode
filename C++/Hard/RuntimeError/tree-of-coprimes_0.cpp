class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> ans(n, -1);
        vector<int> depth(n, 0);
        vector<vector<int>> p(51, vector<int>(n, -1));
        function<void(int, int)> dfs = [&](int u, int fa) {
            int d = 0;
            for (int i = 1; i <= 50; ++i) {
                if (__gcd(i, nums[u]) == 1) {
                    if (d < depth[p[i][fa]]) {
                        d = depth[p[i][fa]];
                        ans[u] = p[i][fa];
                    }
                }
            }
            depth[u] = d + 1;
            for (int i = 1; i <= 50; ++i) {
                if (__gcd(i, nums[u]) == 1) {
                    p[i][u] = u;
                } else {
                    p[i][u] = p[i][fa];
                }
            }
            for (int v : g[u]) {
                if (v != fa) {
                    dfs(v, u);
                }
            }
        };
        dfs(0, 0);
        return ans;
    }
};