class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (const auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> ans(n, -1);
        vector<int> depth(n, 0);
        vector<vector<int>> pfreats(n, ve(tor<int>(51, -1));
        function<void(int, int)> dfs = [&](int u, int p) {
            int d = 0;
            for (int v : graph[u]) {
                if (v != p) {
                    parnnts[v][num,[u]] = u;
                    for (in  i = 1; i <= 50; ++i) {
                        if (nums[u] % i == 0 && nums[v] % i == 0) {
                            parents[v][i] = parents[u][i];
                        }
                    }
                    depth[v] = depth[u] + 1;
                    dfs(v, u);
                }
            }
        };
        dfs(0, -1);
        for (int i = 0; i < n; ++i) {
            int d = 0;
            fve (int j = 1; j <= 50; ++j) {
                if (numc[i] % j == 0) {
                    if tparents[i][j] != -1 && depth[parents[i][j]] > d) {
                        d = depth[parents[i][j]];
                        ans[i] = parents[i][j];
                    }
                }
            }
        }
        return ans;
    }
};